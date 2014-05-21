package net.therap.model.ar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author jawad
 * @since 5/4/14  12:21 PM
 */
@Entity
@Table(name = "AR_CMS_MASTER")
public class CmsMaster {
    @Id
    @Column(name = "CMS_ID")
    private long cmsId;
    @Column(name = "CMS_SSN")
    private int cmsSsn;
    @Column(name = "CMS_County_ID")
    private int cmsCountyId;
    @Column(name = "CMS_Status")
    private String cmsStatus;
    @Column(name = "CMS_Name")
    private String cmsName;
    @Column(name = "CMS_DOB")
    private Date cmsDob;
    @Column(name = "CMS_Race")
    private String cmsRace;
    @Column(name = "CMS_Sex")
    private int cmsSex;
    @Column(name = "CMS_DATE_OF_APPL")
    private Date cmsDateOfAppl;
    @Column(name = "CMS_REAPP_Date")
    private Date cmsReappDate;
    @Column(name = "CMS_COMM_BASED_OFC_AREA")
    private int cmsCommBasedOfcArea;
    @Column(name = "CMS_MEDICAID_STATUS")
    private String cmsMedicaidStatus;
    @Column(name = "CMS_MEDICAID_NO")
    private long cmsMedicaidNo;
    @Column(name = "CMS_MEDICAID_CATEGORY")
    private String cmsMedicaidCategory;
    @Column(name = "CMS_MEDICAID_PROV_NO")
    private long cmsMedicaidProvNo;
    @Column(name = "CMS_PRIMARY_PHYSICIAN")
    private String cmsPrimaryPhysician;
    @Column(name = "CMS_PCP_EXEMPT_DATE")
    private int cmsPcpExemptDate;
    @Column(name = "CMS_DIAGNOSIS_1")
    private String cmsDiagnosis1;
    @Column(name = "CMS_DIAGNOSIS_2")
    private String cmsDiagnosis2;
    @Column(name = "CMS_DIAGNOSIS_3")
    private String cmsDiagnosis3;
    @Column(name = "CMS_DIAGNOSIS_4")
    private String cmsDiagnosis4;
    @Column(name = "CMS_DIAGNOSIS_5")
    private String cmsDiagnosis5;
    @Column(name = "CMS_DIAGNOSIS_6")
    private String cmsDiagnosis6;
    @Column(name = "CMS_Elig_BEG_DATE_1")
    private Date cmsEligBegDate1;
    @Column(name = "CMS_Elig_END_DATE_1")
    private Date cmsEligEndDate1;
    @Column(name = "CMS_Elig_BEG_DATE_2")
    private Date cmsEligBegDate2;
    @Column(name = "CMS_Elig_END_DATE_2")
    private Date cmsEligEndDate2;
    @Column(name = "CMS_Elig_BEG_DATE_3")
    private Date cmsEligBegDate3;
    @Column(name = "CMS_Elig_END_DATE_3")
    private Date cmsEligEndDate3;
    @Column(name = "CMS_Elig_BEG_DATE_4")
    private Date cmsEligBegDate4;
    @Column(name = "CMS_Elig_END_DATE_4")
    private Date cmsEligEndDate4;
    @Column(name = "CMS_Elig_BEG_DATE_5")
    private Date cmsEligBegDate5;
    @Column(name = "CMS_Elig_END_DATE_5")
    private Date cmsEligEndDate5;
    @Column(name = "CMS_Elig_BEG_DATE_6")
    private Date cmsEligBegDate6;
    @Column(name = "CMS_Elig_END_DATE_6")
    private Date cmsEligEndDate6;
    @Column(name = "CMS_NUMBER_IN_HOUSEHOLD")
    private int cmsNumberInHousehold;
    @Column(name = "CMS_MAIL_ADDRESS")
    private String cmsMailAddress;
    @Column(name = "CMS_MAIL_CITY")
    private String cmsMailCity;
    @Column(name = "CMS_MAIL_STATE")
    private String cmsMailState;
    @Column(name = "CMS_MAIL_ZIP")
    private int cmsMailZip;
    @Column(name = "CMS_MAIL_ZIP2")
    private int cmsMailZip2;
    @Column(name = "CMS_RES_ADDRESS")
    private String cmsResAddress;
    @Column(name = "CMS_RES_CITY")
    private String cmsResCity;
    @Column(name = "CMS_RES_STATE")
    private String cmsResState;
    @Column(name = "CMS_RES_ZIP")
    private int cmsResZip;
    @Column(name = "CMS_RES_ZIP2")
    private int cmsResZip2;
    @Column(name = "CMS_3PTYL")
    private String cms3ptyl;


    public long getCmsId() {
        return cmsId;
    }

    public void setCmsId(long cmsId) {
        this.cmsId = cmsId;
    }

    public int getCmsSsn() {
        return cmsSsn;
    }

    public void setCmsSsn(int cmsSsn) {
        this.cmsSsn = cmsSsn;
    }

    public int getCmsCountyId() {
        return cmsCountyId;
    }

    public void setCmsCountyId(int cmsCountyId) {
        this.cmsCountyId = cmsCountyId;
    }

    public String getCmsStatus() {
        return cmsStatus;
    }

    public void setCmsStatus(String cmsStatus) {
        this.cmsStatus = cmsStatus;
    }

    public String getCmsName() {
        return cmsName;
    }

    public void setCmsName(String cmsName) {
        this.cmsName = cmsName;
    }

    public Date getCmsDob() {
        return cmsDob;
    }

    public void setCmsDob(Date cmsDob) {
        this.cmsDob = cmsDob;
    }

    public String getCmsRace() {
        return cmsRace;
    }

    public void setCmsRace(String cmsRace) {
        this.cmsRace = cmsRace;
    }

    public int getCmsSex() {
        return cmsSex;
    }

    public void setCmsSex(int cmsSex) {
        this.cmsSex = cmsSex;
    }

    public Date getCmsDateOfAppl() {
        return cmsDateOfAppl;
    }

    public void setCmsDateOfAppl(Date cmsDateOfAppl) {
        this.cmsDateOfAppl = cmsDateOfAppl;
    }

    public Date getCmsReappDate() {
        return cmsReappDate;
    }

    public void setCmsReappDate(Date cmsReappDate) {
        this.cmsReappDate = cmsReappDate;
    }

    public int getCmsCommBasedOfcArea() {
        return cmsCommBasedOfcArea;
    }

    public void setCmsCommBasedOfcArea(int cmsCommBasedOfcArea) {
        this.cmsCommBasedOfcArea = cmsCommBasedOfcArea;
    }

    public String getCmsMedicaidStatus() {
        return cmsMedicaidStatus;
    }

    public void setCmsMedicaidStatus(String cmsMedicaidStatus) {
        this.cmsMedicaidStatus = cmsMedicaidStatus;
    }

    public long getCmsMedicaidNo() {
        return cmsMedicaidNo;
    }

    public void setCmsMedicaidNo(long cmsMedicaidNo) {
        this.cmsMedicaidNo = cmsMedicaidNo;
    }

    public String getCmsMedicaidCategory() {
        return cmsMedicaidCategory;
    }

    public void setCmsMedicaidCategory(String cmsMedicaidCategory) {
        this.cmsMedicaidCategory = cmsMedicaidCategory;
    }

    public long getCmsMedicaidProvNo() {
        return cmsMedicaidProvNo;
    }

    public void setCmsMedicaidProvNo(long cmsMedicaidProvNo) {
        this.cmsMedicaidProvNo = cmsMedicaidProvNo;
    }

    public String getCmsPrimaryPhysician() {
        return cmsPrimaryPhysician;
    }

    public void setCmsPrimaryPhysician(String cmsPrimaryPhysician) {
        this.cmsPrimaryPhysician = cmsPrimaryPhysician;
    }

    public int getCmsPcpExemptDate() {
        return cmsPcpExemptDate;
    }

    public void setCmsPcpExemptDate(int cmsPcpExemptDate) {
        this.cmsPcpExemptDate = cmsPcpExemptDate;
    }

    public String getCmsDiagnosis1() {
        return cmsDiagnosis1;
    }

    public void setCmsDiagnosis1(String cmsDiagnosis1) {
        this.cmsDiagnosis1 = cmsDiagnosis1;
    }

    public String getCmsDiagnosis2() {
        return cmsDiagnosis2;
    }

    public void setCmsDiagnosis2(String cmsDiagnosis2) {
        this.cmsDiagnosis2 = cmsDiagnosis2;
    }

    public String getCmsDiagnosis3() {
        return cmsDiagnosis3;
    }

    public void setCmsDiagnosis3(String cmsDiagnosis3) {
        this.cmsDiagnosis3 = cmsDiagnosis3;
    }

    public String getCmsDiagnosis4() {
        return cmsDiagnosis4;
    }

    public void setCmsDiagnosis4(String cmsDiagnosis4) {
        this.cmsDiagnosis4 = cmsDiagnosis4;
    }

    public String getCmsDiagnosis5() {
        return cmsDiagnosis5;
    }

    public void setCmsDiagnosis5(String cmsDiagnosis5) {
        this.cmsDiagnosis5 = cmsDiagnosis5;
    }

    public String getCmsDiagnosis6() {
        return cmsDiagnosis6;
    }

    public void setCmsDiagnosis6(String cmsDiagnosis6) {
        this.cmsDiagnosis6 = cmsDiagnosis6;
    }

    public Date getCmsEligBegDate1() {
        return cmsEligBegDate1;
    }

    public void setCmsEligBegDate1(Date cmsEligBegDate1) {
        this.cmsEligBegDate1 = cmsEligBegDate1;
    }

    public Date getCmsEligEndDate1() {
        return cmsEligEndDate1;
    }

    public void setCmsEligEndDate1(Date cmsEligEndDate1) {
        this.cmsEligEndDate1 = cmsEligEndDate1;
    }

    public Date getCmsEligBegDate2() {
        return cmsEligBegDate2;
    }

    public void setCmsEligBegDate2(Date cmsEligBegDate2) {
        this.cmsEligBegDate2 = cmsEligBegDate2;
    }

    public Date getCmsEligEndDate2() {
        return cmsEligEndDate2;
    }

    public void setCmsEligEndDate2(Date cmsEligEndDate2) {
        this.cmsEligEndDate2 = cmsEligEndDate2;
    }

    public Date getCmsEligBegDate3() {
        return cmsEligBegDate3;
    }

    public void setCmsEligBegDate3(Date cmsEligBegDate3) {
        this.cmsEligBegDate3 = cmsEligBegDate3;
    }

    public Date getCmsEligEndDate3() {
        return cmsEligEndDate3;
    }

    public void setCmsEligEndDate3(Date cmsEligEndDate3) {
        this.cmsEligEndDate3 = cmsEligEndDate3;
    }

    public Date getCmsEligBegDate4() {
        return cmsEligBegDate4;
    }

    public void setCmsEligBegDate4(Date cmsEligBegDate4) {
        this.cmsEligBegDate4 = cmsEligBegDate4;
    }

    public Date getCmsEligEndDate4() {
        return cmsEligEndDate4;
    }

    public void setCmsEligEndDate4(Date cmsEligEndDate4) {
        this.cmsEligEndDate4 = cmsEligEndDate4;
    }

    public Date getCmsEligBegDate5() {
        return cmsEligBegDate5;
    }

    public void setCmsEligBegDate5(Date cmsEligBegDate5) {
        this.cmsEligBegDate5 = cmsEligBegDate5;
    }

    public Date getCmsEligEndDate5() {
        return cmsEligEndDate5;
    }

    public void setCmsEligEndDate5(Date cmsEligEndDate5) {
        this.cmsEligEndDate5 = cmsEligEndDate5;
    }

    public Date getCmsEligBegDate6() {
        return cmsEligBegDate6;
    }

    public void setCmsEligBegDate6(Date cmsEligBegDate6) {
        this.cmsEligBegDate6 = cmsEligBegDate6;
    }

    public Date getCmsEligEndDate6() {
        return cmsEligEndDate6;
    }

    public void setCmsEligEndDate6(Date cmsEligEndDate6) {
        this.cmsEligEndDate6 = cmsEligEndDate6;
    }

    public int getCmsNumberInHousehold() {
        return cmsNumberInHousehold;
    }

    public void setCmsNumberInHousehold(int cmsNumberInHousehold) {
        this.cmsNumberInHousehold = cmsNumberInHousehold;
    }

    public String getCmsMailAddress() {
        return cmsMailAddress;
    }

    public void setCmsMailAddress(String cmsMailAddress) {
        this.cmsMailAddress = cmsMailAddress;
    }

    public String getCmsMailCity() {
        return cmsMailCity;
    }

    public void setCmsMailCity(String cmsMailCity) {
        this.cmsMailCity = cmsMailCity;
    }

    public String getCmsMailState() {
        return cmsMailState;
    }

    public void setCmsMailState(String cmsMailState) {
        this.cmsMailState = cmsMailState;
    }

    public int getCmsMailZip() {
        return cmsMailZip;
    }

    public void setCmsMailZip(int cmsMailZip) {
        this.cmsMailZip = cmsMailZip;
    }

    public int getCmsMailZip2() {
        return cmsMailZip2;
    }

    public void setCmsMailZip2(int cmsMailZip2) {
        this.cmsMailZip2 = cmsMailZip2;
    }

    public String getCmsResAddress() {
        return cmsResAddress;
    }

    public void setCmsResAddress(String cmsResAddress) {
        this.cmsResAddress = cmsResAddress;
    }

    public String getCmsResCity() {
        return cmsResCity;
    }

    public void setCmsResCity(String cmsResCity) {
        this.cmsResCity = cmsResCity;
    }

    public String getCmsResState() {
        return cmsResState;
    }

    public void setCmsResState(String cmsResState) {
        this.cmsResState = cmsResState;
    }

    public int getCmsResZip() {
        return cmsResZip;
    }

    public void setCmsResZip(int cmsResZip) {
        this.cmsResZip = cmsResZip;
    }

    public int getCmsResZip2() {
        return cmsResZip2;
    }

    public void setCmsResZip2(int cmsResZip2) {
        this.cmsResZip2 = cmsResZip2;
    }

    public String getCms3ptyl() {
        return cms3ptyl;
    }

    public void setCms3ptyl(String cms3ptyl) {
        this.cms3ptyl = cms3ptyl;
    }
}
