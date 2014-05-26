package net.therap.util;

import net.therap.config.FormIdGenerator;
import net.therap.config.FormIdGeneratorBean;
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

        ddsRootGenderMap.put("M", "Male");
        ddsRootGenderMap.put("F", "Female");

//        cmsMasterGenderMap.put(0, );
        cmsMasterGenderMap.put(1, "Male");
        cmsMasterGenderMap.put(2, "Female");
        cmsMasterGenderMap.put(3, "Unknown");


    }

    public static Client createClient(CmsMaster cmsMaster, DdsRoot ddsRoot, Provider provider, String oversightId) {
        Client client = new Client();
        FormIdGenerator formIdGenerator = new FormIdGeneratorBean();
//        client.setFormId(formIdGenerator.generate());
        client.setLastName(ddsRoot.getClientLastname());
        client.setFirstName(ddsRoot.getClientFirstname());
        client.setMiddleName(ddsRoot.getClientMiddlename());
        client.setBirthDate(cmsMaster.getCmsDob());
        client.setGender(String.valueOf(cmsMaster.getCmsSex()));
        client.setClientAdmissionDate(ddsRoot.getClientDateOfApplication());
        client.setMedicaidNumber(String.valueOf(cmsMaster.getCmsMedicaidNo()));
        client.setSsn(String.valueOf(cmsMaster.getCmsSsn()));
        createArClientOversight(client, provider, oversightId);
        //Remaining fields:
        return client;
    }

    public static ClientDetail createClientDetail(CmsMaster cmsMaster, DdsRoot ddsRoot) {
        ClientDetail clientDetail = new ClientDetail();
        clientDetail.setMailingCity(cmsMaster.getCmsMailCity());
        clientDetail.setMailingState(cmsMaster.getCmsMailState());
        clientDetail.setMailingZip(String.valueOf(cmsMaster.getCmsMailZip()));
        clientDetail.setRaCity(cmsMaster.getCmsResCity());
        clientDetail.setRaState(cmsMaster.getCmsResState());
        clientDetail.setRaZip(String.valueOf(cmsMaster.getCmsResZip()));
        clientDetail.setRaceList(createRaceList(cmsMaster, ddsRoot));

        //Remaining fields : cms mail address, cms res address, cms mail zip 2, cms res zip 2
        return clientDetail;
    }

    public static ArClient createArClient(CmsMaster cmsMaster, DdsRoot ddsRoot, DdsCmFinance finance,
                                          List<MedicaidDenial> denials, DdsField field) {
        ArClient arClient = new ArClient();
//        arClient.setFormId();
        arClient.setDdsCaseloadStatus(field.getFieldCaseloadStatus());
        arClient.setDdsCaseloadCloseReason(field.getFieldReasonClosed());
        arClient.setCountyCode(ddsRoot.getClientCounty());
        arClient.setDiplomaDate(ddsRoot.getClientDateOfDiploma());
        arClient.setPrimaryDisability(ddsRoot.getClientPrimary());
        arClient.setSecondaryDisability(ddsRoot.getClientSecondary());
        arClient.setAdaptiveBehaviorIndicator(ddsRoot.getClientAdapt());
        arClient.setPrimaryHomeLanguage(ddsRoot.getClientLanguage());
        arClient.setNumberInHousehold(ddsRoot.getClientHouse());
        arClient.setMonthlyMedicalBill(Double.valueOf(finance.getDdcmMonthlybills()));
        arClient.setSsnDenialLetterDate(finance.getDdcmDenyDisSsi());
        arClient.setMedicaidDenialLetterDate(finance.getDdcmDenyResMedicaid());
        arClient.setReceivingSobra(Boolean.valueOf(finance.getDdcmApplysobra()));
        arClient.setReceivingMedicaid(Boolean.valueOf(finance.getDdcmApplymedicaid()));
        arClient.setReceivingSsi(Boolean.valueOf(finance.getDdcmApplyssi()));
        arClient.setMedicallyNeedy(Boolean.valueOf(finance.getDdcmApplyneedy()));
//        arClient.setMedicaidTypeArkids(ddsRoot.getClientMedicaidType());
        arClient.setResources5WeekSpinDown(finance.getDdcmDenyRes5week());
        arClient.setDisabilitySsi(finance.getDdcmDenyDisSsi());
        arClient.setDisabilityMedicaidDenialDate(finance.getDdcmDenyDisMedicaid());
        arClient.setSobraAppliedDate(finance.getDdcmSobraDate());
        arClient.setNeedyDeterminationDate(finance.getDdcmNeedyDate());
        arClient.setMedicaidDeterminationDate(finance.getDdcmMedicaidDate());
        arClient.setSsiDeterminationDate(finance.getDdcmSsiDate());
        arClient.setParentsRefusalDate(finance.getDdcmParentRefusalDate());
        arClient.setDdsId(ddsRoot.getClientId());
        arClient.setCmsId(cmsMaster.getCmsId());
        arClient.setCmsStatusCode(cmsMaster.getCmsStatus());
        arClient.setCmsApplyDate(cmsMaster.getCmsDateOfAppl());
        arClient.setCmsReapplyDate(cmsMaster.getCmsReappDate());
        arClient.setCmsCommOfficeAreaCode(String.valueOf(cmsMaster.getCmsCommBasedOfcArea()));
        arClient.setCmsMedicaidStatus(cmsMaster.getCmsMedicaidStatus());
        arClient.setCmsMedicaidCategory(cmsMaster.getCmsMedicaidCategory());
        arClient.setCmsMedicaidProviderNo(cmsMaster.getCmsMedicaidProvNo());
        arClient.setCmsPrimaryPhysician(cmsMaster.getCmsPrimaryPhysician());
        arClient.setThirdPartyLiability(cmsMaster.getCms3ptyl());
        arClient.setMedicaidDenials(createMedicaidDenialList(denials));
        return null;
    }

    public static List<ArClientFamilyMember> createArClientFamilyMembers(DdsCmFinance finance) {
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
        List<ArClientMedicaidDenial> arClientMedicaidDenials = new ArrayList<ArClientMedicaidDenial>();
        for(MedicaidDenial medicaidDenial : medicaidDenials) {
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
        if (master.getCmsRace() != null) {
            race.setCode(Integer.parseInt(master.getCmsRace()));
        } else if (ddsRoot.getClientRace() != null) {
            race.setCode(Integer.parseInt(ddsRoot.getClientRace()));
        }
        raceList.add(race);
        return raceList;
    }

    public static Oversight createArClientOversight(Client client, Provider provider, String assignedId){

        Oversight oversight = new Oversight();

        oversight.setClient(client);
        client.setOversights(new HashSet<Oversight>());
        client.getOversights().add(oversight);

        oversight.setAssignedId(assignedId);
        oversight.setAgency(provider);

        return oversight;
    }


    }
