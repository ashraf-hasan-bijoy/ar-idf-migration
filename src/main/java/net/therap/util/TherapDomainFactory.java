package net.therap.util;

import net.therap.config.FormIdGenerator;
import net.therap.config.FormIdGeneratorBean;
import net.therap.db.entity.ar.*;
import net.therap.db.entity.common.*;
import net.therap.db.util.CommonForm;
import net.therap.model.ar.*;

import java.util.*;

/**
 * @author ashraf
 * @since 5/20/14
 */
public class TherapDomainFactory {

    private static Map<String, Integer> cmsMasterClientRaceMap = new HashMap<String, Integer>();
    private static Map<String, Integer> ddsRootClientRaceMap = new HashMap<String, Integer>();
    private static Map<Integer, String> cmsMasterGenderMap = new HashMap<Integer, String>();
    private static Map<String, String> ddsRootGenderMap = new HashMap<String, String>();


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
        client.setFormId(formIdGenerator.generate(provider, CommonForm.FT_CLIENT, false));

        if (ddsRoot != null) {
            client.setClientAdmissionDate(ddsRoot.getClientDateOfApplication());

            client.setMedicaidNumber(ddsRoot.getClientMedicaidNo() != null ? String.valueOf(ddsRoot.getClientMedicaidNo()) : null);
            client.setSsn(ddsRoot.getClientSsn() != null ? String.valueOf(ddsRoot.getClientSsn()) : null);
            client.setBirthDate(ddsRoot.getClientDateOfBirth());
            client.setGender(ddsRootGenderMap.get(ddsRoot.getClientSex()));

            setClientNameByDdsRoot(client, ddsRoot);
        }

        if (cmsMaster != null) {

            client.setMedicaidNumber(cmsMaster.getCmsMedicaidNo() != null ? String.valueOf(cmsMaster.getCmsMedicaidNo())
                    : client.getMedicaidNumber());
            client.setSsn(cmsMaster.getCmsSsn() != null ? String.valueOf(cmsMaster.getCmsSsn()) : client.getSsn());
            client.setBirthDate(cmsMaster.getCmsDob() != null ? cmsMaster.getCmsDob() : client.getBirthDate());
            client.setGender(cmsMaster.getCmsSex() != null ? cmsMasterGenderMap.get(cmsMaster.getCmsSex()) : client.getGender());
            setClientNameByCmsMaster(client, cmsMaster);
        }


        client.setProvider(provider);
        createArClientOversight(client, provider, oversightId);
        return client;
    }

    public static void setClientNameByCmsMaster(Client client, CmsMaster master) {
        String[] names = master.getCmsName().split("\\s");
        client.setLastName(names[0]);

        if (names.length == 3) {
            client.setMiddleName(names[1]);
            client.setFirstName(names[2]);
        } else if (names.length > 1) {
            client.setFirstName(StringUtils.join(" ", Arrays.copyOfRange(names, 1, names.length)));
            client.setMiddleName(null);
        }
    }

    public static void setClientNameByDdsRoot(Client client, DdsRoot ddsRoot) {
        client.setFirstName(ddsRoot.getClientFirstname());
        client.setMiddleName(ddsRoot.getClientMiddlename());
        client.setLastName(ddsRoot.getClientLastname());
    }


    public static ClientDetail createClientDetail(CmsMaster cmsMaster, DdsRoot ddsRoot) {

        ClientDetail clientDetail = new ClientDetail();

        if (cmsMaster != null) {
            //clientDetail.setMailingStreet1(cmsMaster.getCmsMailAddress());
            //clientDetail.setMailingStreet2(cmsMaster.getCmsMailAddress());
            clientDetail.setMailingCity(cmsMaster.getCmsMailCity());
            clientDetail.setMailingState(cmsMaster.getCmsMailState());
            clientDetail.setMailingZip(
                    StringUtils.joinWithDelimiter("-", cmsMaster.getCmsMailZip(), cmsMaster.getCmsMailZip2()));
//            clientDetail.setRaStreet1(cmsMaster.getCmsResAddress());
//            clientDetail.setRaStreet2(cmsMaster.getCmsResAddress());
            clientDetail.setRaCity(cmsMaster.getCmsResCity());
            clientDetail.setRaState(cmsMaster.getCmsResState());
            clientDetail.setRaZip(StringUtils.joinWithDelimiter("-", cmsMaster.getCmsResZip(), cmsMaster.getCmsResZip2()));
        }

        clientDetail.setRaceList(createRaceList(cmsMaster, ddsRoot));

        //Remaining fields : cms mail address, cms res address
        return clientDetail;
    }

    public static ArClient createArClient(CmsMaster cmsMaster, DdsRoot ddsRoot, DdsCmFinance finance,
                                          List<MedicaidDenial> denials, DdsField field, Provider provider) {
        ArClient arClient = new ArClient();

        if (ddsRoot != null) {
            arClient.setCountyCode(StringUtils.isEmpty(ddsRoot.getClientCounty()) ? null : ArCounty.valueOf(ddsRoot.getClientCounty()));
            arClient.setDiplomaDate(ddsRoot.getClientDateOfDiploma());
            arClient.setPrimaryDisability(ddsRoot.getClientPrimary());
            arClient.setSecondaryDisability(ddsRoot.getClientSecondary());
            arClient.setAdaptiveBehaviorIndicator(ddsRoot.getClientAdapt());
            arClient.setPrimaryHomeLanguage(ddsRoot.getClientLanguage());
            arClient.setNumberInHousehold(ddsRoot.getClientHouse());
            arClient.setDdsId(ddsRoot.getClientId());
        }

        if (cmsMaster != null) {
            arClient.setCmsId(cmsMaster.getCmsId());
            arClient.setCmsStatusCode(StringUtils.isEmpty(cmsMaster.getCmsStatus()) ? null : ArCmsStatus.valueOf(cmsMaster.getCmsStatus()));
            arClient.setCmsApplyDate(cmsMaster.getCmsDateOfAppl());
            arClient.setCmsReapplyDate(cmsMaster.getCmsReappDate());
            arClient.setCmsCommOfficeAreaCode(cmsMaster.getCmsCommBasedOfcArea() == null ? null : String.valueOf(cmsMaster.getCmsCommBasedOfcArea()));
            arClient.setCmsMedicaidStatus(cmsMaster.getCmsMedicaidStatus());
            arClient.setCmsMedicaidCategory(cmsMaster.getCmsMedicaidCategory());
            arClient.setCmsMedicaidProviderNo(cmsMaster.getCmsMedicaidProvNo());
            arClient.setCmsPrimaryPhysician(cmsMaster.getCmsPrimaryPhysician());
            arClient.setThirdPartyLiability(cmsMaster.getCms3ptyl());
            arClient.setNumberInHousehold(cmsMaster.getCmsNumberInHousehold() == null ? null : String.valueOf(cmsMaster.getCmsNumberInHousehold()));
        }

        if (field != null) {
            arClient.setDdsCaseloadStatus(StringUtils.isEmpty(field.getFieldCaseloadStatus()) ? null : ArCaseloadStatus.valueOf(field.getFieldCaseloadStatus()));
            arClient.setDdsCaseloadCloseReason(StringUtils.isEmpty(field.getFieldReasonClosed()) ? null : ArReasonClosed.valueOf(field.getFieldReasonClosed()));
        }

        if (finance != null) {
            arClient.setMonthlyMedicalBill(finance.getDdcmMonthlybills() == null ? null : Double.valueOf(finance.getDdcmMonthlybills()));
            arClient.setSsnDenialLetterDate(finance.getDdcmDenyDisSsi());
            arClient.setMedicaidDenialLetterDate(finance.getDdcmDenyResMedicaid());
            arClient.setReceivingSobra(finance.getDdcmApplysobra() == null ? null : Boolean.valueOf(finance.getDdcmApplysobra()));
            arClient.setReceivingMedicaid(finance.getDdcmApplymedicaid() == null ? null : Boolean.valueOf(finance.getDdcmApplymedicaid()));
            arClient.setReceivingSsi(finance.getDdcmApplyssi() == null ? null : Boolean.valueOf(finance.getDdcmApplyssi()));
            arClient.setMedicallyNeedy(finance.getDdcmApplyneedy() == null ? null : Boolean.valueOf(finance.getDdcmApplyneedy()));
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
        arClient.setFormId(formIdGenerator.generate(provider, CommonForm.FT_AR_IDF_EXT, false));

        arClient.setMedicaidDenials(createMedicaidDenialList(denials));
        arClient.setFamilyMembers(createArClientFamilyMembers(finance));
        arClient.setEligibilityDurations(createArEligibilityDurations(cmsMaster));
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
        arClientFamilyMember.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge()) ? null : Integer.valueOf(finance.getDdcmCmfAge()));
        arClientFamilyMember.setMonthlyIncome(finance.getDdcmCmfIncome());
        arClientFamilyMember.setRelationship(finance.getDdcmCmfRelation() == null ? null : String.valueOf(finance.getDdcmCmfRelation()));
        arClientFamilyMember.setSourceOfIncome(finance.getDdcmCmfSource());

        arClientFamilyMembers.add(arClientFamilyMember);

        ArClientFamilyMember arClientFamilyMember1 = new ArClientFamilyMember();
        arClientFamilyMember1.setName(finance.getDdcmCmfName1());
        arClientFamilyMember1.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge1()) ? null : Integer.valueOf(finance.getDdcmCmfAge1()));
        arClientFamilyMember1.setMonthlyIncome(finance.getDdcmCmfIncome1());
        arClientFamilyMember1.setRelationship(finance.getDdcmCmfRelation1() == null ? null : String.valueOf(finance.getDdcmCmfRelation1()));
        arClientFamilyMember.setSourceOfIncome(finance.getDdcmCmfSource1());

        arClientFamilyMembers.add(arClientFamilyMember1);

        ArClientFamilyMember arClientFamilyMember2 = new ArClientFamilyMember();
        arClientFamilyMember2.setName(finance.getDdcmCmfName2());
        arClientFamilyMember2.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge2()) ? null : Integer.valueOf(finance.getDdcmCmfAge2()));
        arClientFamilyMember2.setMonthlyIncome(finance.getDdcmCmfIncome2());
        arClientFamilyMember2.setRelationship(finance.getDdcmCmfRelation2() == null ? null : String.valueOf(finance.getDdcmCmfRelation2()));
        arClientFamilyMember.setSourceOfIncome(finance.getDdcmCmfSource2());

        arClientFamilyMembers.add(arClientFamilyMember2);

        ArClientFamilyMember arClientFamilyMember3 = new ArClientFamilyMember();
        arClientFamilyMember3.setName(finance.getDdcmCmfName3());
        arClientFamilyMember3.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge3()) ? null : Integer.valueOf(finance.getDdcmCmfAge3()));
        arClientFamilyMember3.setMonthlyIncome(finance.getDdcmCmfIncome3());
        arClientFamilyMember3.setRelationship(finance.getDdcmCmfRelation3() == null ? null : String.valueOf(finance.getDdcmCmfRelation3()));
        arClientFamilyMember.setSourceOfIncome(finance.getDdcmCmfSource3());

        arClientFamilyMembers.add(arClientFamilyMember3);

        ArClientFamilyMember arClientFamilyMember4 = new ArClientFamilyMember();
        arClientFamilyMember4.setName(finance.getDdcmCmfName4());
        arClientFamilyMember4.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge4()) ? null : Integer.valueOf(finance.getDdcmCmfAge4()));
        arClientFamilyMember4.setMonthlyIncome(finance.getDdcmCmfIncome4());
        arClientFamilyMember4.setRelationship(finance.getDdcmCmfRelation4() == null ? null : String.valueOf(finance.getDdcmCmfRelation4()));
        arClientFamilyMember.setSourceOfIncome(finance.getDdcmCmfSource4());

        arClientFamilyMembers.add(arClientFamilyMember4);

        ArClientFamilyMember arClientFamilyMember5 = new ArClientFamilyMember();
        arClientFamilyMember5.setName(finance.getDdcmCmfName5());
        arClientFamilyMember5.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge5()) ? null : Integer.valueOf(finance.getDdcmCmfAge5()));
        arClientFamilyMember5.setMonthlyIncome(finance.getDdcmCmfIncome5());
        arClientFamilyMember5.setRelationship(finance.getDdcmCmfRelation5() == null ? null : String.valueOf(finance.getDdcmCmfRelation5()));
        arClientFamilyMember.setSourceOfIncome(finance.getDdcmCmfSource5());

        arClientFamilyMembers.add(arClientFamilyMember5);

        ArClientFamilyMember arClientFamilyMember6 = new ArClientFamilyMember();
        arClientFamilyMember6.setName(finance.getDdcmCmfName6());
        arClientFamilyMember6.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge6()) ? null : Integer.valueOf(finance.getDdcmCmfAge6()));
        arClientFamilyMember6.setMonthlyIncome(finance.getDdcmCmfIncome6());
        arClientFamilyMember6.setRelationship(finance.getDdcmCmfRelation6() == null ? null : String.valueOf(finance.getDdcmCmfRelation6()));
        arClientFamilyMember.setSourceOfIncome(finance.getDdcmCmfSource6());

        arClientFamilyMembers.add(arClientFamilyMember6);

        ArClientFamilyMember arClientFamilyMember7 = new ArClientFamilyMember();
        arClientFamilyMember7.setName(finance.getDdcmCmfName7());
        arClientFamilyMember7.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge7()) ? null : Integer.valueOf(finance.getDdcmCmfAge7()));
        arClientFamilyMember7.setMonthlyIncome(finance.getDdcmCmfIncome7());
        arClientFamilyMember7.setRelationship(finance.getDdcmCmfRelation7() == null ? null : String.valueOf(finance.getDdcmCmfRelation7()));
        arClientFamilyMember.setSourceOfIncome(finance.getDdcmCmfSource7());

        arClientFamilyMembers.add(arClientFamilyMember7);

        ArClientFamilyMember arClientFamilyMember8 = new ArClientFamilyMember();
        arClientFamilyMember8.setName(finance.getDdcmCmfName8());
        arClientFamilyMember8.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge8()) ? null : Integer.valueOf(finance.getDdcmCmfAge8()));
        arClientFamilyMember8.setMonthlyIncome(finance.getDdcmCmfIncome8());
        arClientFamilyMember8.setRelationship(finance.getDdcmCmfRelation8() == null ? null : String.valueOf(finance.getDdcmCmfRelation8()));
        arClientFamilyMember.setSourceOfIncome(finance.getDdcmCmfSource8());

        arClientFamilyMembers.add(arClientFamilyMember8);
        return arClientFamilyMembers;
    }

    public static List<ArEligibilityDuration> createArEligibilityDurations(CmsMaster master) {
        if (master == null) {
            return null;
        }

        List<ArEligibilityDuration> arEligibilityDurations = new ArrayList<ArEligibilityDuration>();

        ArEligibilityDuration arEligibilityDuration1 = new ArEligibilityDuration();
        arEligibilityDuration1.setBeginDate(master.getCmsEligBegDate1());
        arEligibilityDuration1.setEndDate(master.getCmsEligEndDate1());

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
            arClientMedicaidDenial.setMedicaidDenialOptionToDelete(
                    StringUtils.isEmpty(medicaidDenial.getMedicaidDenialOptionDelete()) ? null : Boolean.valueOf(medicaidDenial.getMedicaidDenialOptionDelete()));
            arClientMedicaidDenials.add(arClientMedicaidDenial);
        }

        return arClientMedicaidDenials;
    }

    public static List<Race> createRaceList(CmsMaster master, DdsRoot ddsRoot) {
        List<Race> raceList = new ArrayList<Race>();
        Integer raceCode = null;

        if (master != null && StringUtils.isEmpty(master.getCmsRace())) {
            raceCode = cmsMasterClientRaceMap.get(master.getCmsRace());
        } else if (ddsRoot != null && StringUtils.isEmpty(ddsRoot.getClientRace())) {
            raceCode = ddsRootClientRaceMap.get(ddsRoot.getClientRace());
        }

        if (raceCode != null) {
            Race race = new Race();
            race.setCode(raceCode);
            raceList.add(race);
        }

        return raceList;
    }


    public static Oversight createArClientOversight(Client client, Provider provider, String assignedId) {

        Oversight oversight = new Oversight();

        oversight.setClient(client);
        oversight.setAssignedId(assignedId);
        oversight.setAgency(provider);

        client.setOversights(new HashSet<Oversight>());
        client.getOversights().add(oversight);

        return oversight;
    }


}
