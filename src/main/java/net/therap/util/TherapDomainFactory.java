package net.therap.util;

import net.therap.config.FormIdGenerator;
import net.therap.config.FormIdGeneratorBean;
import net.therap.db.entity.ar.*;
import net.therap.db.entity.common.*;
import net.therap.db.util.CommonForm;
import net.therap.db.util.Globals;
import net.therap.model.ar.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author ashraf
 * @since 5/20/14
 */
public class TherapDomainFactory {

    private static Logger logger = LoggerFactory.getLogger(TherapDomainFactory.class);
    private static Map<String, Integer> cmsMasterClientRaceMap = new HashMap<String, Integer>();
    private static Map<String, Integer> ddsRootClientRaceMap = new HashMap<String, Integer>();
    private static Map<Integer, String> cmsMasterGenderMap = new HashMap<Integer, String>();
    private static Map<String, String> ddsRootGenderMap = new HashMap<String, String>();
    private static Map<String, Integer> cmsMasterClientStatusMap = new HashMap<String, Integer>();

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
        cmsMasterClientRaceMap.put("0", 9999);
        cmsMasterClientRaceMap.put("7", 9999);
        cmsMasterClientRaceMap.put("9", 9999);

        ddsRootGenderMap.put("M", "M");
        ddsRootGenderMap.put("F", "F");

        cmsMasterGenderMap.put(0, null);
        cmsMasterGenderMap.put(1, "M");
        cmsMasterGenderMap.put(2, "F");
        cmsMasterGenderMap.put(3, "U");

        cmsMasterClientStatusMap.put("A", Globals.CLIENT_STATUS_ADMITTED);
        cmsMasterClientStatusMap.put("C", Globals.CLIENT_STATUS_DISCHARGED);
        cmsMasterClientStatusMap.put("D", Globals.CLIENT_STATUS_DISCHARGED);
        cmsMasterClientStatusMap.put("J", Globals.CLIENT_STATUS_ADMITTED);
        cmsMasterClientStatusMap.put("K", Globals.CLIENT_STATUS_ADMITTED);
        cmsMasterClientStatusMap.put("M", Globals.CLIENT_STATUS_DISCHARGED);
        cmsMasterClientStatusMap.put("P", Globals.CLIENT_STATUS_PENDING);
        cmsMasterClientStatusMap.put("X", Globals.CLIENT_STATUS_ADMITTED);
        cmsMasterClientStatusMap.put("W", Globals.CLIENT_STATUS_DISCHARGED);
    }

    public static Client createClient(CmsMaster cmsMaster, DdsRoot ddsRoot, Provider provider, String oversightId) {
        Client client = new Client();
        FormIdGenerator formIdGenerator = new FormIdGeneratorBean();
        client.setFormId(formIdGenerator.generate(provider, CommonForm.FT_IDF, false));

        if (ddsRoot != null) {
            client.setClientAdmissionDate(ddsRoot.getClientDateOfApplication());

            client.setMedicaidNumber(ddsRoot.getClientMedicaidNo() != null ? String.valueOf(ddsRoot.getClientMedicaidNo()) : null);
            client.setSsn(ddsRoot.getClientSsn() != null ? String.valueOf(ddsRoot.getClientSsn()) : null);
            client.setBirthDate(ddsRoot.getClientDateOfBirth());
            client.setGender(ddsRoot.getClientSex() != null ? ddsRootGenderMap.get(ddsRoot.getClientSex()) : null);
            client.setStatus(Globals.CLIENT_STATUS_ADMITTED);

            setClientNameByDdsRoot(client, ddsRoot);
        }

        if (cmsMaster != null) {

            client.setMedicaidNumber(cmsMaster.getCmsMedicaidNo() != null ? String.valueOf(cmsMaster.getCmsMedicaidNo())
                    : client.getMedicaidNumber());
            client.setSsn(cmsMaster.getCmsSsn() != null ? String.valueOf(cmsMaster.getCmsSsn()) : client.getSsn());
            client.setBirthDate(cmsMaster.getCmsDob() != null ? cmsMaster.getCmsDob() : client.getBirthDate());
            client.setGender(cmsMaster.getCmsSex() != null ? cmsMasterGenderMap.get(cmsMaster.getCmsSex()) : client.getGender());
            if (cmsMaster.getCmsStatus() != null) {
                if (cmsMasterClientStatusMap.keySet().contains(cmsMaster.getCmsStatus())) {
                    client.setStatus(cmsMasterClientStatusMap.get(cmsMaster.getCmsStatus()));
                } else {
                    logger.info("[ERROR:MAPPING_NOT_FOUND] CMS Status for Client= " + cmsMaster.getCmsStatus());
                }

            } else if (client.getStatus() == 0) {
                client.setStatus(Globals.CLIENT_STATUS_PENDING);
            }
            setClientNameByCmsMaster(client, cmsMaster);
        }


        client.setTz("US/Central");
        client.setProvider(provider);
        createArClientOversight(client, provider, oversightId);
        return client;
    }

    public static void setClientNameByCmsMaster(Client client, CmsMaster master) {
        String[] names = master.getCmsName().split("\\s");

        if (names.length < 3) {
            client.setLastName(names[0]);
            client.setFirstName(names.length > 1 ? names[1] : null);
            client.setMiddleName(null);
        } else if (names.length == 3) {
            client.setLastName(names[0]);
            client.setFirstName(names[1]);
            client.setMiddleName(names[2]);
        } else if (names.length > 3) {
            client.setLastName(StringUtils.join(" ", Arrays.copyOfRange(names, 0, 2)));
            client.setFirstName(StringUtils.join(" ", Arrays.copyOfRange(names, 2, names.length)));
            client.setMiddleName(null);
        }
    }


    public static void setClientNameByDdsRoot(Client client, DdsRoot ddsRoot) {
        client.setFirstName(ddsRoot.getClientFirstname());
        client.setMiddleName(ddsRoot.getClientMiddlename());
        client.setLastName(ddsRoot.getClientLastname());
    }

    public static ClientDetail createClientDetail(CmsMaster cmsMaster, DdsRoot ddsRoot, Country country) {

        ClientDetail clientDetail = new ClientDetail();

        if (cmsMaster != null) {
            clientDetail.setMailingStreet1(cmsMaster.getCmsMailAddress());
            clientDetail.setMailingCity(cmsMaster.getCmsMailCity());
            clientDetail.setMailingState(cmsMaster.getCmsMailState());
            clientDetail.setMailingZip(
                    StringUtils.joinWithDelimiter("-", cmsMaster.getCmsMailZip(), cmsMaster.getCmsMailZip2()));
            clientDetail.setRaStreet1(cmsMaster.getCmsResAddress());
            clientDetail.setRaCity(cmsMaster.getCmsResCity());
            clientDetail.setRaState(cmsMaster.getCmsResState());
            clientDetail.setRaZip(StringUtils.joinWithDelimiter("-", cmsMaster.getCmsResZip(), cmsMaster.getCmsResZip2()));
        }

        clientDetail.setRaCountry(country);
        clientDetail.setMailingCountry(country);

        clientDetail.setClientTz("US/Central");
        clientDetail.setRaceList(createRaceList(cmsMaster, ddsRoot));

        return clientDetail;
    }

    public static ArClient createArClient(CmsMaster cmsMaster, DdsRoot ddsRoot, DdsCmFinance finance,
                                          List<MedicaidDenial> denials, DdsField field, DdsFinancial financial, Provider provider) {
        ArClient arClient = new ArClient();

        if (ddsRoot != null) {
            arClient.setCountyCode(StringUtils.isEmpty(ddsRoot.getClientCounty()) ? null : getArCounty(ddsRoot.getClientCounty()));
            arClient.setDiplomaDate(ddsRoot.getClientDateOfDiploma());
            arClient.setPrimaryDisability(getArDisability(ddsRoot, "p"));
            arClient.setSecondaryDisability(getArDisability(ddsRoot, "s"));
            arClient.setAdaptiveBehaviorIndicator(ddsRoot.getClientAdapt());
            arClient.setPrimaryHomeLanguage(StringUtils.isNotEmpty(ddsRoot.getClientLanguage()) ? getArLanguage(ddsRoot) : null);
            arClient.setNumberInHousehold(ddsRoot.getClientHouse());
            arClient.setDdsId(ddsRoot.getClientId());
            arClient.setDdsStatus(StringUtils.isNotEmpty(ddsRoot.getClientStatus()) ? getArDdsStatus(ddsRoot) : null);
        }

        if (cmsMaster != null) {
            arClient.setCmsId(cmsMaster.getCmsId());
            arClient.setCmsStatusCode(StringUtils.isEmpty(cmsMaster.getCmsStatus()) ? null : getArCmsStatus(cmsMaster));
            arClient.setCmsApplyDate(cmsMaster.getCmsDateOfAppl());
            arClient.setCmsReapplyDate(cmsMaster.getCmsReappDate());
            arClient.setCmsCommOfficeAreaCode(cmsMaster.getCmsCommBasedOfcArea() == null ? null : String.valueOf(cmsMaster.getCmsCommBasedOfcArea()));
            arClient.setCmsMedicaidStatus(cmsMaster.getCmsMedicaidStatus());
            arClient.setCmsMedicaidCategory(cmsMaster.getCmsMedicaidCategory());
            arClient.setCmsMedicaidProviderNo(cmsMaster.getCmsMedicaidProvNo());
            arClient.setCmsPrimaryPhysician(cmsMaster.getCmsPrimaryPhysician());
            arClient.setThirdPartyLiability(cmsMaster.getCms3ptyl());
            arClient.setNumberInHousehold(cmsMaster.getCmsNumberInHousehold() == null ? arClient.getNumberInHousehold() : String.valueOf(cmsMaster.getCmsNumberInHousehold()));
        }

        if (field != null) {
            arClient.setDdsCaseloadStatus(StringUtils.isEmpty(field.getFieldCaseloadStatus()) ? null
                    : field.getFieldCaseloadStatus().equals("0") ? ArCaseloadStatus.U : getArCaseloadStatus(field));
            arClient.setDdsCaseloadCloseReason(StringUtils.isEmpty(field.getFieldReasonClosed()) ? null : getArReasonClosed(field));
        }

        if (finance != null) {
            arClient.setMonthlyMedicalBill(finance.getDdcmMonthlybills() == null ? null : Double.valueOf(finance.getDdcmMonthlybills()));
            arClient.setSsnDenialLetterDate(finance.getDdcmDenyDisSsi());
            arClient.setMedicaidDenialLetterDate(finance.getDdcmDenyResMedicaid());
            arClient.setReceivingSobra(finance.getDdcmApplysobra() == null ? null : convertToBoolean(finance.getDdcmApplysobra()));
            arClient.setReceivingMedicaid(finance.getDdcmApplymedicaid() == null ? null : convertToBoolean(finance.getDdcmApplymedicaid()));
            arClient.setReceivingSsi(finance.getDdcmApplyssi() == null ? null : convertToBoolean(finance.getDdcmApplyssi()));
            arClient.setMedicallyNeedy(finance.getDdcmApplyneedy() == null ? null : convertToBoolean(finance.getDdcmApplyneedy()));
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
        arClient.setArClientGuardianAddresses(createGuardianAddress(financial, field));
        arClient.setProvider(provider);
        setArProgram(arClient, cmsMaster, ddsRoot);

        return arClient;
    }


    private static ArCounty getArCounty(String code) {
        for (ArCounty ac : ArCounty.values()) {
            if (ac.toString().equals(code)) return ac;
        }

        logger.info("[ERROR:MAPPING_NOT_FOUND]  County= " + code);
        return null;
    }

    private static ArLanguage getArLanguage(DdsRoot ddsRoot) {
        for (ArLanguage arLanguage : ArLanguage.values()) {
            if (arLanguage.getCode().equalsIgnoreCase(ddsRoot.getClientLanguage())) {
                return arLanguage;
            }
        }
        logger.info("[ERROR:MAPPING_NOT_FOUND] Language= " + ddsRoot.getClientLanguage());
        return null;
    }

    private static ArCmsStatus getArCmsStatus(CmsMaster cmsMaster) {
        for (ArCmsStatus arCmsStatus : ArCmsStatus.values()) {
            if (arCmsStatus.toString().equalsIgnoreCase(cmsMaster.getCmsStatus())) {
                return arCmsStatus;
            }
        }
        logger.info("[ERROR:MAPPING_NOT_FOUND] CMS Status For AR Client= " + cmsMaster.getCmsStatus());
        return null;
    }

    private static ArReasonClosed getArReasonClosed(DdsField field) {
        for (ArReasonClosed arReasonClosed : ArReasonClosed.values()) {
            if (arReasonClosed.toString().equalsIgnoreCase(field.getFieldReasonClosed())) {
                return arReasonClosed;
            }
        }
        logger.info("[ERROR:MAPPING_NOT_FOUND] Reason Closed= " + field.getFieldReasonClosed());
        return null;
    }

    public static ArCaseloadStatus getArCaseloadStatus(DdsField field) {
        for (ArCaseloadStatus arCaseloadStatus : ArCaseloadStatus.values()) {
            if (arCaseloadStatus.name().equalsIgnoreCase(field.getFieldCaseloadStatus())) {
                return arCaseloadStatus;
            }
        }
        logger.info("[ERROR:MAPPING_NOT_FOUND] Caseload Status= " + field.getFieldCaseloadStatus());
        return null;
    }

    public static ArGuardianType getArGuardianType(String guardianType) {
        for (ArGuardianType arGuardianType : ArGuardianType.values()) {
            if (arGuardianType.getCode().equalsIgnoreCase(guardianType)) {
                return arGuardianType;
            }
        }
        logger.info("[ERROR:MAPPING_NOT_FOUND] Guardian Type= " + guardianType);
        return null;
    }

    public static ArDdsStatus getArDdsStatus(DdsRoot ddsRoot) {
        for (ArDdsStatus arDdsStatus : ArDdsStatus.values()) {
            if (arDdsStatus.getCode().equalsIgnoreCase(ddsRoot.getClientStatus())) {
                return arDdsStatus;
            }
        }
        logger.info("[ERROR:MAPPING_NOT_FOUND] DDS Status= " + ddsRoot.getClientStatus());
        return null;
    }

    public static ArDisability getArDisability(DdsRoot ddsRoot, String type) {

        String disability = type.equals("p") ? ddsRoot.getClientPrimary() : ddsRoot.getClientSecondary();

        if (StringUtils.isEmpty(disability)) {
            return null;
        }

        String disabilityCode = disability.startsWith("0") ? disability : "0" + disability;
        for (ArDisability arDisability : ArDisability.values()) {
            if (arDisability.getCode().equalsIgnoreCase(disabilityCode)) {
                return arDisability;
            }
        }
        logger.info("[ERROR:MAPPING_NOT_FOUND] Disability = " + disability + " Type : " + (type.equals("p") ? "Primary" : "Secondary"));
        return null;
    }

    private static void setArProgram(ArClient arClient, CmsMaster cmsMaster, DdsRoot ddsRoot) {
        if (cmsMaster != null && cmsMaster.getValidData() == 1) {
            arClient.setTitleFiveProgram(true);
        }

        if (ddsRoot != null) {
            int allStatus = ddsRoot.getValidData();
            while (true) {
                int status = allStatus % 10;
                allStatus = allStatus / 10;
                if (status > 0) {
                    if (status == 1) {
                        arClient.setEiProgram(true);
                    } else if (status == 2) {
                        arClient.setDdtcsProgram(true);
                    } else if (status == 3) {
                        arClient.setEcProgram(true);
                    }
                } else {
                    break;
                }
            }
        }
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

        if (isNotEmptyArClientFamilyMember(arClientFamilyMember)) {
            arClientFamilyMembers.add(arClientFamilyMember);
        }

        ArClientFamilyMember arClientFamilyMember1 = new ArClientFamilyMember();
        arClientFamilyMember1.setName(finance.getDdcmCmfName1());
        arClientFamilyMember1.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge1()) ? null : Integer.valueOf(finance.getDdcmCmfAge1()));
        arClientFamilyMember1.setMonthlyIncome(finance.getDdcmCmfIncome1());
        arClientFamilyMember1.setRelationship(finance.getDdcmCmfRelation1() == null ? null : String.valueOf(finance.getDdcmCmfRelation1()));
        arClientFamilyMember1.setSourceOfIncome(finance.getDdcmCmfSource1());

        if (isNotEmptyArClientFamilyMember(arClientFamilyMember1)) {
            arClientFamilyMembers.add(arClientFamilyMember1);
        }

        ArClientFamilyMember arClientFamilyMember2 = new ArClientFamilyMember();
        arClientFamilyMember2.setName(finance.getDdcmCmfName2());
        arClientFamilyMember2.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge2()) ? null : Integer.valueOf(finance.getDdcmCmfAge2()));
        arClientFamilyMember2.setMonthlyIncome(finance.getDdcmCmfIncome2());
        arClientFamilyMember2.setRelationship(finance.getDdcmCmfRelation2() == null ? null : String.valueOf(finance.getDdcmCmfRelation2()));
        arClientFamilyMember2.setSourceOfIncome(finance.getDdcmCmfSource2());

        if (isNotEmptyArClientFamilyMember(arClientFamilyMember2)) {
            arClientFamilyMembers.add(arClientFamilyMember2);
        }

        ArClientFamilyMember arClientFamilyMember3 = new ArClientFamilyMember();
        arClientFamilyMember3.setName(finance.getDdcmCmfName3());
        arClientFamilyMember3.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge3()) ? null : Integer.valueOf(finance.getDdcmCmfAge3()));
        arClientFamilyMember3.setMonthlyIncome(finance.getDdcmCmfIncome3());
        arClientFamilyMember3.setRelationship(finance.getDdcmCmfRelation3() == null ? null : String.valueOf(finance.getDdcmCmfRelation3()));
        arClientFamilyMember3.setSourceOfIncome(finance.getDdcmCmfSource3());

        if (isNotEmptyArClientFamilyMember(arClientFamilyMember3)) {
            arClientFamilyMembers.add(arClientFamilyMember3);
        }

        ArClientFamilyMember arClientFamilyMember4 = new ArClientFamilyMember();
        arClientFamilyMember4.setName(finance.getDdcmCmfName4());
        arClientFamilyMember4.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge4()) ? null : Integer.valueOf(finance.getDdcmCmfAge4()));
        arClientFamilyMember4.setMonthlyIncome(finance.getDdcmCmfIncome4());
        arClientFamilyMember4.setRelationship(finance.getDdcmCmfRelation4() == null ? null : String.valueOf(finance.getDdcmCmfRelation4()));
        arClientFamilyMember4.setSourceOfIncome(finance.getDdcmCmfSource4());

        if (isNotEmptyArClientFamilyMember(arClientFamilyMember4)) {
            arClientFamilyMembers.add(arClientFamilyMember4);
        }

        ArClientFamilyMember arClientFamilyMember5 = new ArClientFamilyMember();
        arClientFamilyMember5.setName(finance.getDdcmCmfName5());
        arClientFamilyMember5.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge5()) ? null : Integer.valueOf(finance.getDdcmCmfAge5()));
        arClientFamilyMember5.setMonthlyIncome(finance.getDdcmCmfIncome5());
        arClientFamilyMember5.setRelationship(finance.getDdcmCmfRelation5() == null ? null : String.valueOf(finance.getDdcmCmfRelation5()));
        arClientFamilyMember5.setSourceOfIncome(finance.getDdcmCmfSource5());

        if (isNotEmptyArClientFamilyMember(arClientFamilyMember5)) {
            arClientFamilyMembers.add(arClientFamilyMember5);
        }

        ArClientFamilyMember arClientFamilyMember6 = new ArClientFamilyMember();
        arClientFamilyMember6.setName(finance.getDdcmCmfName6());
        arClientFamilyMember6.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge6()) ? null : Integer.valueOf(finance.getDdcmCmfAge6()));
        arClientFamilyMember6.setMonthlyIncome(finance.getDdcmCmfIncome6());
        arClientFamilyMember6.setRelationship(finance.getDdcmCmfRelation6() == null ? null : String.valueOf(finance.getDdcmCmfRelation6()));
        arClientFamilyMember6.setSourceOfIncome(finance.getDdcmCmfSource6());

        if (isNotEmptyArClientFamilyMember(arClientFamilyMember6)) {
            arClientFamilyMembers.add(arClientFamilyMember6);
        }

        ArClientFamilyMember arClientFamilyMember7 = new ArClientFamilyMember();
        arClientFamilyMember7.setName(finance.getDdcmCmfName7());
        arClientFamilyMember7.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge7()) ? null : Integer.valueOf(finance.getDdcmCmfAge7()));
        arClientFamilyMember7.setMonthlyIncome(finance.getDdcmCmfIncome7());
        arClientFamilyMember7.setRelationship(finance.getDdcmCmfRelation7() == null ? null : String.valueOf(finance.getDdcmCmfRelation7()));
        arClientFamilyMember7.setSourceOfIncome(finance.getDdcmCmfSource7());

        if (isNotEmptyArClientFamilyMember(arClientFamilyMember7)) {
            arClientFamilyMembers.add(arClientFamilyMember7);
        }

        ArClientFamilyMember arClientFamilyMember8 = new ArClientFamilyMember();
        arClientFamilyMember8.setName(finance.getDdcmCmfName8());
        arClientFamilyMember8.setAge(StringUtils.isEmpty(finance.getDdcmCmfAge8()) ? null : Integer.valueOf(finance.getDdcmCmfAge8()));
        arClientFamilyMember8.setMonthlyIncome(finance.getDdcmCmfIncome8());
        arClientFamilyMember8.setRelationship(finance.getDdcmCmfRelation8() == null ? null : String.valueOf(finance.getDdcmCmfRelation8()));
        arClientFamilyMember8.setSourceOfIncome(finance.getDdcmCmfSource8());

        if (isNotEmptyArClientFamilyMember(arClientFamilyMember8)) {
            arClientFamilyMembers.add(arClientFamilyMember8);
        }
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

        if (isNotEmptyArEligibilityDuration(arEligibilityDuration1)) {
            arEligibilityDurations.add(arEligibilityDuration1);
        }

        ArEligibilityDuration arEligibilityDuration2 = new ArEligibilityDuration();
        arEligibilityDuration2.setBeginDate(master.getCmsEligBegDate2());
        arEligibilityDuration2.setEndDate(master.getCmsEligEndDate2());

        if (isNotEmptyArEligibilityDuration(arEligibilityDuration2)) {
            arEligibilityDurations.add(arEligibilityDuration2);
        }

        ArEligibilityDuration arEligibilityDuration3 = new ArEligibilityDuration();
        arEligibilityDuration3.setBeginDate(master.getCmsEligBegDate3());
        arEligibilityDuration3.setEndDate(master.getCmsEligEndDate3());

        if (isNotEmptyArEligibilityDuration(arEligibilityDuration3)) {
            arEligibilityDurations.add(arEligibilityDuration3);
        }

        ArEligibilityDuration arEligibilityDuration4 = new ArEligibilityDuration();
        arEligibilityDuration4.setBeginDate(master.getCmsEligBegDate4());
        arEligibilityDuration4.setEndDate(master.getCmsEligEndDate4());

        if (isNotEmptyArEligibilityDuration(arEligibilityDuration4)) {
            arEligibilityDurations.add(arEligibilityDuration4);
        }

        ArEligibilityDuration arEligibilityDuration5 = new ArEligibilityDuration();
        arEligibilityDuration5.setBeginDate(master.getCmsEligBegDate5());
        arEligibilityDuration5.setEndDate(master.getCmsEligEndDate5());

        if (isNotEmptyArEligibilityDuration(arEligibilityDuration5)) {
            arEligibilityDurations.add(arEligibilityDuration5);
        }

        ArEligibilityDuration arEligibilityDuration6 = new ArEligibilityDuration();
        arEligibilityDuration6.setBeginDate(master.getCmsEligBegDate6());
        arEligibilityDuration6.setEndDate(master.getCmsEligEndDate6());

        if (isNotEmptyArEligibilityDuration(arEligibilityDuration6)) {
            arEligibilityDurations.add(arEligibilityDuration6);
        }

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
                    StringUtils.isEmpty(medicaidDenial.getMedicaidDenialOptionDelete()) ? null : convertToBoolean(medicaidDenial.getMedicaidDenialOptionDelete()));
            arClientMedicaidDenials.add(arClientMedicaidDenial);
        }

        return arClientMedicaidDenials;
    }

    public static List<Race> createRaceList(CmsMaster master, DdsRoot ddsRoot) {
        List<Race> raceList = new ArrayList<Race>();
        Integer raceCode = null;
        String race = null;

        if (master != null && StringUtils.isNotEmpty(master.getCmsRace())) {
            race = master.getCmsRace();
            raceCode = cmsMasterClientRaceMap.get(race);
        } else if (ddsRoot != null && StringUtils.isNotEmpty(ddsRoot.getClientRace())) {
            race = ddsRoot.getClientRace();
            raceCode = ddsRootClientRaceMap.get(race);
        }

        if (raceCode != null) {
            Race therapRace = new Race();
            therapRace.setCode(raceCode);
            raceList.add(therapRace);
        } else if (StringUtils.isNotEmpty(race)) {
            logger.info("[ERROR:MAPPING_NOT_FOUND] Race= " + race);
        }

        return raceList;
    }

    public static List<ArClientGuardianAddress> createGuardianAddress(DdsFinancial ddsFinancial, DdsField ddsField) {
        List<ArClientGuardianAddress> guardianAddressList = new ArrayList<ArClientGuardianAddress>();

        if (ddsField != null) {
            ArClientGuardianAddress fatherAddress = new ArClientGuardianAddress();
            fatherAddress.setGuardianType(ArGuardianType.FATHER);
            setGuardianName(fatherAddress, ddsField.getFieldFatherName());
            fatherAddress.setAddress(ddsField.getFieldFatherAddress());
            fatherAddress.setCity(ddsField.getFieldFatherCity());
            fatherAddress.setCounty(StringUtils.isNotEmpty(ddsField.getFieldFatherCounty()) ? getArCounty(ddsField.getFieldFatherCounty()) : null);
            fatherAddress.setState(ddsField.getFieldFatherState());
            fatherAddress.setZip(ddsField.getFieldFatherZip().matches("0*") ? null : ddsField.getFieldFatherZip());
            fatherAddress.setPhone1(ddsField.getFieldFatherPhoneRes().matches("0*") ? null : ddsField.getFieldFatherPhoneRes());
            fatherAddress.setPhone2(ddsField.getFieldFatherPhoneBus().matches("0*") ? null : ddsField.getFieldFatherPhoneBus());
            fatherAddress.setPhone3(ddsField.getFieldFatherPhoneMes().matches("0*") ? null : ddsField.getFieldFatherPhoneMes());

            if (isNotEmptyArClientGuardianAddress(fatherAddress)) {
                guardianAddressList.add(fatherAddress);
            }

            ArClientGuardianAddress motherAddress = new ArClientGuardianAddress();
            motherAddress.setGuardianType(ArGuardianType.MOTHER);
            setGuardianName(motherAddress, ddsField.getFieldMotherName());
            motherAddress.setAddress(ddsField.getFieldMotherAddress());
            motherAddress.setCity(ddsField.getFieldMotherCity());
            motherAddress.setState(ddsField.getFieldMotherState());
            motherAddress.setZip(ddsField.getFieldMotherZip().matches("0*") ? null : ddsField.getFieldMotherZip());
            motherAddress.setCounty(StringUtils.isNotEmpty(ddsField.getFieldMotherCounty()) ? getArCounty(ddsField.getFieldMotherCounty()) : null);
            motherAddress.setPhone1(ddsField.getFieldMotherPhoneRes().matches("0*") ? null : ddsField.getFieldMotherPhoneRes());
            motherAddress.setPhone2(ddsField.getFieldMotherPhoneBus().matches("0*") ? null : ddsField.getFieldMotherPhoneBus());
            motherAddress.setPhone3(ddsField.getFieldMotherPhoneMes().matches("0*") ? null : ddsField.getFieldMotherPhoneMes());

            if (isNotEmptyArClientGuardianAddress(motherAddress)) {
                guardianAddressList.add(motherAddress);
            }
        }

        if (ddsFinancial != null) {
            ArClientGuardianAddress guardianAddress = new ArClientGuardianAddress();
            guardianAddress.setGuardianType(StringUtils.isEmpty(ddsFinancial.getGuardianType()) ? null : getArGuardianType(ddsFinancial.getGuardianType()));
            setGuardianName(guardianAddress, ddsFinancial.getGuardianName());
            guardianAddress.setAddress(ddsFinancial.getGuardianAddress());
            guardianAddress.setCity(ddsFinancial.getGuardianCity());
            guardianAddress.setState(ddsFinancial.getGuardianState());
            guardianAddress.setZip(ddsFinancial.getGuardianZip().matches("0*") ? null : ddsFinancial.getGuardianZip());
            guardianAddress.setPhone1(ddsFinancial.getGuardianPhone().matches("0*") ? null : ddsFinancial.getGuardianPhone());

            if (isNotEmptyArClientGuardianAddress(guardianAddress)) {
                guardianAddressList.add(guardianAddress);
            }
        }


        return guardianAddressList;
    }

    public static void setGuardianName(ArClientGuardianAddress address, String guardianName) {
        if (StringUtils.isEmpty(guardianName)) {
            return;
        }

        String[] names = guardianName.split("\\s");
        address.setLastName(names[0]);

        if (names.length == 3) {
            address.setFirstName(names[1]);
            address.setMiddleName(names[2]);
        } else if (names.length > 1) {
            address.setFirstName(StringUtils.join(" ", Arrays.copyOfRange(names, 1, names.length)));
            address.setMiddleName(null);
        }
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

    public static Boolean convertToBoolean(String value) {
        return value.equalsIgnoreCase("Y");
    }

    public static String removeExtraChars(String name, int maxLength) {
        if (name.length() > maxLength) {
            name = name.substring(0, maxLength);
        }
        return name;
    }

    private static boolean isNotEmptyArClientFamilyMember(ArClientFamilyMember arClientFamilyMember) {
        boolean age = arClientFamilyMember.getAge() != null;
        boolean monthlyIncome = arClientFamilyMember.getMonthlyIncome() != null;
        boolean sourceOfIncome = StringUtils.isNotEmpty(arClientFamilyMember.getSourceOfIncome());
        boolean name = StringUtils.isNotEmpty(arClientFamilyMember.getName());
        boolean relationship = StringUtils.isNotEmpty(arClientFamilyMember.getRelationship());

        return (age || monthlyIncome || sourceOfIncome || name || relationship);
    }

    private static boolean isNotEmptyArEligibilityDuration(ArEligibilityDuration arEligibilityDuration) {
        boolean beginDate = arEligibilityDuration.getBeginDate() != null;
        boolean endDate = arEligibilityDuration.getEndDate() != null;

        return (beginDate || endDate);
    }

    private static boolean isNotEmptyArClientGuardianAddress(ArClientGuardianAddress arClientGuardianAddress) {
        boolean address = StringUtils.isNotEmpty(arClientGuardianAddress.getAddress());
        boolean city = StringUtils.isNotEmpty(arClientGuardianAddress.getCity());
        boolean county = arClientGuardianAddress.getCounty() != null;
        boolean state = StringUtils.isNotEmpty(arClientGuardianAddress.getState());
        boolean zip = StringUtils.isNotEmpty(arClientGuardianAddress.getZip());
        boolean phone1 = arClientGuardianAddress.getPhone1() != null;
        boolean phone2 = arClientGuardianAddress.getPhone2() != null;
        boolean phone3 = arClientGuardianAddress.getPhone3() != null;

        return (address || city || county || zip || state || phone1 || phone2 || phone3);
    }

}
