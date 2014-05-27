package net.therap.util;

import net.therap.config.FormIdGenerator;
import net.therap.config.FormIdGeneratorBean;
import net.therap.db.entity.ar.*;
import net.therap.db.entity.common.*;
import net.therap.model.ar.*;
import net.therap.model.therap.*;

import java.util.*;

/**
 * @author ashraf
 * @since 5/20/14
 */
public class TherapDomainFactory {

    public static Map<String, Integer> cmsMasterClientRaceMap = new HashMap<String, Integer>();
    public static Map<String, Integer> ddsRootClientRaceMap = new HashMap<String, Integer>();
    public static Map<Integer, String> cmsMasterGenderMap = new HashMap<Integer, String>();
    public static Map<String, String> ddsRootGenderMap = new HashMap<String, String>();


    static {
        ddsRootClientRaceMap.put("0", 9999);
        ddsRootClientRaceMap.put("1", 4);
        ddsRootClientRaceMap.put("2", 2);
        ddsRootClientRaceMap.put("3", 11);
        ddsRootClientRaceMap.put("4", 9999);
        ddsRootClientRaceMap.put("5", 9999);
        ddsRootClientRaceMap.put("6", 9999);
        ddsRootClientRaceMap.put("7", 1);
        ddsRootClientRaceMap.put("8", 9999);
        ddsRootClientRaceMap.put("9", 15);

        cmsMasterClientRaceMap.put("8", 4);
        cmsMasterClientRaceMap.put("2", 2);
        cmsMasterClientRaceMap.put("3", 9999);
        cmsMasterClientRaceMap.put("6", 9999);
        cmsMasterClientRaceMap.put("1", 1);
        cmsMasterClientRaceMap.put("4", 9999);
        cmsMasterClientRaceMap.put("5", 15);

        ddsRootGenderMap.put("M", "M");
        ddsRootGenderMap.put("F", "F");

//        cmsMasterGenderMap.put(0, );
        cmsMasterGenderMap.put(1, "M");
        cmsMasterGenderMap.put(2, "F");
        cmsMasterGenderMap.put(3, "M");


    }

    public static Client createClient(CmsMaster cmsMaster, DdsRoot ddsRoot, Provider provider, String oversightId) {
        Client client = new Client();
        FormIdGenerator formIdGenerator = new FormIdGeneratorBean();
        client.setFormId(formIdGenerator.generate(provider, "CLIENT", true));

        boolean isCmsMasterEmpty = cmsMaster == null;
        boolean isDdsRootEmpty = ddsRoot == null;

        String cmsLastName = null, ddsLastName = null;
        String cmsFirstName = null, ddsFirstName = null;
        String cmsMiddleName = null, ddsMiddleName = null;
        Date cmsBirth = null, ddsBirth = null;
        Integer cmsSex = null;
        String ddsSex = null;

        if (!isCmsMasterEmpty) {
            client.setMedicaidNumber(String.valueOf(cmsMaster.getCmsMedicaidNo()));
            client.setSsn(String.valueOf(cmsMaster.getCmsSsn()));
            client.setBirthDate(cmsMaster.getCmsDob());

            cmsSex = cmsMaster.getCmsSex();
            cmsBirth = cmsMaster.getCmsDob();
            String[] names = cmsMaster.getCmsName().split("\\s");
            cmsLastName = names[0];

            if (names.length == 3) {
                cmsMiddleName = names[1];
                cmsFirstName = names[2];
            } else {
                cmsFirstName = StringUtils.join(" ", Arrays.copyOfRange(names, 1, names.length));
            }
        }

        if (!isDdsRootEmpty) {
            client.setClientAdmissionDate(ddsRoot.getClientDateOfApplication());
            ddsFirstName = ddsRoot.getClientFirstname();
            ddsMiddleName = ddsRoot.getClientMiddlename();
            ddsLastName = ddsRoot.getClientLastname();
            ddsBirth = ddsRoot.getClientDateOfBirth();
            ddsSex = ddsRoot.getClientSex();

        }

        client.setLastName(StringUtils.isEmpty(cmsLastName) ? ddsLastName : cmsLastName);
        client.setMiddleName(StringUtils.isEmpty(cmsMiddleName) ? ddsMiddleName : cmsMiddleName);
        client.setFirstName(StringUtils.isEmpty(cmsFirstName) ? ddsFirstName : cmsFirstName);
        client.setGender(cmsSex == null ? ddsRootGenderMap.get(ddsSex) : cmsMasterGenderMap.get(cmsSex));
        client.setBirthDate(cmsBirth == null ? ddsBirth : cmsBirth);

        client.setProvider(provider);
        createArClientOversight(client, provider, oversightId);
        return client;
    }

    public static ClientDetail createClientDetail(CmsMaster cmsMaster, DdsRoot ddsRoot) {

        ClientDetail clientDetail = new ClientDetail();
        boolean isCmsMasterEmpty = cmsMaster == null;
        boolean isDdsRootEmpty = ddsRoot == null;

        if (!isCmsMasterEmpty) {
            clientDetail.setMailingCity(cmsMaster.getCmsMailCity());
            clientDetail.setMailingState(cmsMaster.getCmsMailState());
            clientDetail.setMailingZip(String.valueOf(cmsMaster.getCmsMailZip()));
            clientDetail.setRaCity(cmsMaster.getCmsResCity());
            clientDetail.setRaState(cmsMaster.getCmsResState());
            clientDetail.setRaZip(String.valueOf(cmsMaster.getCmsResZip()));
        }

        if (!isDdsRootEmpty) {

        }


        clientDetail.setRaceList(createRaceList(cmsMaster, ddsRoot));

        //Remaining fields : cms mail address, cms res address, cms mail zip 2, cms res zip 2
        return clientDetail;
    }

    public static ArClient createArClient(CmsMaster cmsMaster, DdsRoot ddsRoot, DdsCmFinance finance,
                                          List<MedicaidDenial> denials, DdsField field, Provider provider) {
        ArClient arClient = new ArClient();

        boolean isCmsMasterEmpty = cmsMaster == null;
        boolean isDdsRootEmpty = ddsRoot == null;
        boolean isFinanceEmpty = finance == null;
        boolean isFieldEmpty = field == null;

        if (!isCmsMasterEmpty) {
            arClient.setCmsId(cmsMaster.getCmsId());
            arClient.setCmsStatusCode(ArCmsStatus.valueOf(cmsMaster.getCmsStatus()));
            arClient.setCmsApplyDate(cmsMaster.getCmsDateOfAppl());
            arClient.setCmsReapplyDate(cmsMaster.getCmsReappDate());
            arClient.setCmsCommOfficeAreaCode(cmsMaster.getCmsCommBasedOfcArea() == null ? null : String.valueOf(cmsMaster.getCmsCommBasedOfcArea()));
            arClient.setCmsMedicaidStatus(cmsMaster.getCmsMedicaidStatus());
            arClient.setCmsMedicaidCategory(cmsMaster.getCmsMedicaidCategory());
            arClient.setCmsMedicaidProviderNo(cmsMaster.getCmsMedicaidProvNo());
            arClient.setCmsPrimaryPhysician(cmsMaster.getCmsPrimaryPhysician());
            arClient.setThirdPartyLiability(cmsMaster.getCms3ptyl());
        }

        if (!isDdsRootEmpty) {
            arClient.setCountyCode(ArCounty.valueOf(ddsRoot.getClientCounty()));
            arClient.setDiplomaDate(ddsRoot.getClientDateOfDiploma());
            arClient.setPrimaryDisability(ddsRoot.getClientPrimary());
            arClient.setSecondaryDisability(ddsRoot.getClientSecondary());
            arClient.setAdaptiveBehaviorIndicator(ddsRoot.getClientAdapt());
            arClient.setPrimaryHomeLanguage(ddsRoot.getClientLanguage());
            arClient.setNumberInHousehold(ddsRoot.getClientHouse());
            arClient.setDdsId(ddsRoot.getClientId());
        }

        if (!isFieldEmpty) {
            arClient.setDdsCaseloadStatus(ArCaseloadStatus.valueOf(field.getFieldCaseloadStatus()));
            arClient.setDdsCaseloadCloseReason(ArReasonClosed.valueOf(field.getFieldReasonClosed()));
        }

        if (!isFinanceEmpty) {
            arClient.setMonthlyMedicalBill(Double.valueOf(finance.getDdcmMonthlybills()));
            arClient.setSsnDenialLetterDate(finance.getDdcmDenyDisSsi());
            arClient.setMedicaidDenialLetterDate(finance.getDdcmDenyResMedicaid());
            arClient.setReceivingSobra(Boolean.valueOf(finance.getDdcmApplysobra()));
            arClient.setReceivingMedicaid(Boolean.valueOf(finance.getDdcmApplymedicaid()));
            arClient.setReceivingSsi(Boolean.valueOf(finance.getDdcmApplyssi()));
            arClient.setMedicallyNeedy(Boolean.valueOf(finance.getDdcmApplyneedy()));
            //arClient.setMedicaidTypeArkids(ddsRoot.getClientMedicaidType());
            arClient.setResources5WeekSpinDown(finance.getDdcmDenyRes5week());
            arClient.setDisabilitySsi(finance.getDdcmDenyDisSsi());
            arClient.setDisabilityMedicaidDenialDate(finance.getDdcmDenyDisMedicaid());
            arClient.setSobraAppliedDate(finance.getDdcmSobraDate());
            arClient.setNeedyDeterminationDate(finance.getDdcmNeedyDate());
            arClient.setMedicaidDeterminationDate(finance.getDdcmMedicaidDate());
            arClient.setSsiDeterminationDate(finance.getDdcmSsiDate());
            arClient.setParentsRefusalDate(finance.getDdcmParentRefusalDate());
        }

        FormIdGenerator formIdGenerator = new FormIdGeneratorBean();
        arClient.setFormId(formIdGenerator.generate(provider, "ARIDFE", true));

        arClient.setMedicaidDenials(createMedicaidDenialList(denials));
        arClient.setProvider(provider);
        return arClient;
    }

    public static List<ArClientFamilyMember> createArClientFamilyMembers(DdsCmFinance finance) {
        if (finance == null) {
            return null;
        }
        List<ArClientFamilyMember> arClientFamilyMembers = new ArrayList<ArClientFamilyMember>();

        ArClientFamilyMember arClientFamilyMember = new ArClientFamilyMember();
        arClientFamilyMember.setName(finance.getDdcmCmfName());
        arClientFamilyMember.setAge(Integer.parseInt(finance.getDdcmCmfAge()));
        arClientFamilyMember.setMonthlyIncome(finance.getDdcmCmfIncome());
        arClientFamilyMember.setRelationship(String.valueOf(finance.getDdcmCmfRelation()));
        arClientFamilyMember.setSourceOfIncome(finance.getDdcmCmfSource());

        arClientFamilyMembers.add(arClientFamilyMember);

        ArClientFamilyMember arClientFamilyMember1 = new ArClientFamilyMember();
        arClientFamilyMember1.setName(finance.getDdcmCmfName1());
        arClientFamilyMember1.setAge(Integer.valueOf(finance.getDdcmCmfAge1()));
        arClientFamilyMember1.setMonthlyIncome(finance.getDdcmCmfIncome1());
        arClientFamilyMember1.setRelationship(String.valueOf(finance.getDdcmCmfRelation1()));

        arClientFamilyMembers.add(arClientFamilyMember1);

        ArClientFamilyMember arClientFamilyMember2 = new ArClientFamilyMember();
        arClientFamilyMember2.setName(finance.getDdcmCmfName2());
        arClientFamilyMember2.setAge(Integer.valueOf(finance.getDdcmCmfAge2()));
        arClientFamilyMember2.setMonthlyIncome(finance.getDdcmCmfIncome2());
        arClientFamilyMember2.setRelationship(String.valueOf(finance.getDdcmCmfRelation2()));

        arClientFamilyMembers.add(arClientFamilyMember2);

        ArClientFamilyMember arClientFamilyMember3 = new ArClientFamilyMember();
        arClientFamilyMember3.setName(finance.getDdcmCmfName3());
        arClientFamilyMember3.setAge(Integer.valueOf(finance.getDdcmCmfAge3()));
        arClientFamilyMember3.setMonthlyIncome(finance.getDdcmCmfIncome3());
        arClientFamilyMember3.setRelationship(String.valueOf(finance.getDdcmCmfRelation3()));

        arClientFamilyMembers.add(arClientFamilyMember3);

        ArClientFamilyMember arClientFamilyMember4 = new ArClientFamilyMember();
        arClientFamilyMember4.setName(finance.getDdcmCmfName4());
        arClientFamilyMember4.setAge(Integer.valueOf(finance.getDdcmCmfAge4()));
        arClientFamilyMember4.setMonthlyIncome(finance.getDdcmCmfIncome4());
        arClientFamilyMember4.setRelationship(String.valueOf(finance.getDdcmCmfRelation4()));

        arClientFamilyMembers.add(arClientFamilyMember4);

        ArClientFamilyMember arClientFamilyMember5 = new ArClientFamilyMember();
        arClientFamilyMember5.setName(finance.getDdcmCmfName5());
        arClientFamilyMember5.setAge(Integer.valueOf(finance.getDdcmCmfAge5()));
        arClientFamilyMember5.setMonthlyIncome(finance.getDdcmCmfIncome5());
        arClientFamilyMember5.setRelationship(String.valueOf(finance.getDdcmCmfRelation5()));

        arClientFamilyMembers.add(arClientFamilyMember5);

        ArClientFamilyMember arClientFamilyMember6 = new ArClientFamilyMember();
        arClientFamilyMember6.setName(finance.getDdcmCmfName6());
        arClientFamilyMember6.setAge(Integer.valueOf(finance.getDdcmCmfAge6()));
        arClientFamilyMember6.setMonthlyIncome(finance.getDdcmCmfIncome6());
        arClientFamilyMember6.setRelationship(String.valueOf(finance.getDdcmCmfRelation6()));

        arClientFamilyMembers.add(arClientFamilyMember6);

        ArClientFamilyMember arClientFamilyMember7 = new ArClientFamilyMember();
        arClientFamilyMember7.setName(finance.getDdcmCmfName7());
        arClientFamilyMember7.setAge(Integer.valueOf(finance.getDdcmCmfAge7()));
        arClientFamilyMember7.setMonthlyIncome(finance.getDdcmCmfIncome7());
        arClientFamilyMember7.setRelationship(String.valueOf(finance.getDdcmCmfRelation7()));

        arClientFamilyMembers.add(arClientFamilyMember7);

        ArClientFamilyMember arClientFamilyMember8 = new ArClientFamilyMember();
        arClientFamilyMember8.setName(finance.getDdcmCmfName8());
        arClientFamilyMember8.setAge(Integer.valueOf(finance.getDdcmCmfAge8()));
        arClientFamilyMember8.setMonthlyIncome(finance.getDdcmCmfIncome8());
        arClientFamilyMember8.setRelationship(String.valueOf(finance.getDdcmCmfRelation8()));

        arClientFamilyMembers.add(arClientFamilyMember8);
        return arClientFamilyMembers;
    }

    public static List<ArEligibilityDuration> createArEligibilityDurations(CmsMaster master) {
        List<ArEligibilityDuration> arEligibilityDurations = new ArrayList<ArEligibilityDuration>();

        ArEligibilityDuration arEligibilityDuration = new ArEligibilityDuration();
        arEligibilityDuration.setBeginDate(master.getCmsEligBegDate1());
        arEligibilityDuration.setEndDate(master.getCmsEligEndDate1());

        arEligibilityDurations.add(arEligibilityDuration);

        ArEligibilityDuration arEligibilityDuration1 = new ArEligibilityDuration();
        arEligibilityDuration1.setBeginDate(master.getCmsEligBegDate2());
        arEligibilityDuration1.setEndDate(master.getCmsEligEndDate2());

        arEligibilityDurations.add(arEligibilityDuration1);

        ArEligibilityDuration arEligibilityDuration2 = new ArEligibilityDuration();
        arEligibilityDuration2.setBeginDate(master.getCmsEligBegDate2());
        arEligibilityDuration2.setEndDate(master.getCmsEligEndDate2());

        arEligibilityDurations.add(arEligibilityDuration2);

        ArEligibilityDuration arEligibilityDuration3 = new ArEligibilityDuration();
        arEligibilityDuration3.setBeginDate(master.getCmsEligBegDate3());
        arEligibilityDuration3.setEndDate(master.getCmsEligEndDate3());

        arEligibilityDurations.add(arEligibilityDuration3);

        ArEligibilityDuration arEligibilityDuration4 = new ArEligibilityDuration();
        arEligibilityDuration4.setBeginDate(master.getCmsEligBegDate4());
        arEligibilityDuration4.setEndDate(master.getCmsEligEndDate4());

        arEligibilityDurations.add(arEligibilityDuration4);

        ArEligibilityDuration arEligibilityDuration5 = new ArEligibilityDuration();
        arEligibilityDuration5.setBeginDate(master.getCmsEligBegDate5());
        arEligibilityDuration5.setEndDate(master.getCmsEligEndDate5());

        arEligibilityDurations.add(arEligibilityDuration5);

        ArEligibilityDuration arEligibilityDuration6 = new ArEligibilityDuration();
        arEligibilityDuration6.setBeginDate(master.getCmsEligBegDate6());
        arEligibilityDuration6.setEndDate(master.getCmsEligEndDate6());

        arEligibilityDurations.add(arEligibilityDuration6);

        return arEligibilityDurations;
    }

    public static List<ArClientMedicaidDenial> createMedicaidDenialList(List<MedicaidDenial> medicaidDenials) {

        if (CollectionUtils.isEmpty(medicaidDenials)) {
            return null;
        }

        List<ArClientMedicaidDenial> arClientMedicaidDenials = new ArrayList<ArClientMedicaidDenial>();
        for (MedicaidDenial medicaidDenial : medicaidDenials) {
            ArClientMedicaidDenial arClientMedicaidDenial = new ArClientMedicaidDenial();
            arClientMedicaidDenial.setMedicaidDenialBeginDate(medicaidDenial.getMedicaidDenialStartDate());
            arClientMedicaidDenial.setMedicaidDenialEndDate(medicaidDenial.getMedicaidDenialEndDate());
            arClientMedicaidDenial.setMedicaidDenialOptionToDelete(Boolean.valueOf(medicaidDenial.getMedicaidDenialOptionDelete()));
            arClientMedicaidDenials.add(arClientMedicaidDenial);
        }

        return arClientMedicaidDenials;
    }

    public static List<Race> createRaceList(CmsMaster master, DdsRoot ddsRoot) {
        List<Race> raceList = new ArrayList<Race>();
        Race race = new Race();
        if (master != null && master.getCmsRace() != null) {
            race.setCode(Integer.parseInt(master.getCmsRace()));
        } else if (ddsRoot != null && ddsRoot.getClientRace() != null) {
            race.setCode(Integer.parseInt(ddsRoot.getClientRace()));
        }
        raceList.add(race);
        return raceList;
    }

    public static Oversight createArClientOversight(Client client, Provider provider, String assignedId) {

        Oversight oversight = new Oversight();

        oversight.setClient(client);
        client.setOversights(new HashSet<Oversight>());
        client.getOversights().add(oversight);

        oversight.setAssignedId(assignedId);
        oversight.setAgency(provider);

        return oversight;
    }


}
