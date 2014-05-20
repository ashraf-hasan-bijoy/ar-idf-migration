package net.therap.model;

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
public class TblCMSMaster {
    @Id
    @Column(name = "CMS_ID")
    private long CMS_ID;
    @Column(name = "CMS_SSN")
    private int CMS_SSN;
    @Column(name = "CMS_County_ID")
    private int CMS_County_ID;
    @Column(name = "CMS_Status")
    private String CMS_Status;
    @Column(name = "CMS_Name")
    private String CMS_Name;
    @Column(name = "CMS_DOB")
    private Date CMS_DOB;
    @Column(name = "CMS_Race")
    private String CMS_Race;
    @Column(name = "CMS_Sex")
    private int CMS_Sex;
    @Column(name = "CMS_DATE_OF_APPL")
    private Date CMS_DATE_OF_APPL;
    @Column(name = "CMS_REAPP_Date")
    private Date CMS_REAPP_Date;
    @Column(name = "CMS_COMM_BASED_OFC_AREA")
    private int CMS_COMM_BASED_OFC_AREA;
    @Column(name = "CMS_MEDICAID_STATUS")
    private String CMS_MEDICAID_STATUS;
    @Column(name = "CMS_MEDICAID_NO")
    private long CMS_MEDICAID_NO;
    @Column(name = "CMS_MEDICAID_CATEGORY")
    private String CMS_MEDICAID_CATEGORY;
    @Column(name = "CMS_MEDICAID_PROV_NO")
    private long CMS_MEDICAID_PROV_NO;
    @Column(name = "CMS_PRIMARY_PHYSICIAN")
    private String CMS_PRIMARY_PHYSICIAN;
    @Column(name = "CMS_PCP_EXEMPT_DATE")
    private Date CMS_PCP_EXEMPT_DATE;
    @Column(name = "CMS_DIAGNOSIS_1")
    private String CMS_DIAGNOSIS_1;
    @Column(name = "CMS_DIAGNOSIS_2")
    private String CMS_DIAGNOSIS_2;
    @Column(name = "CMS_DIAGNOSIS_3")
    private String CMS_DIAGNOSIS_3;
    @Column(name = "CMS_DIAGNOSIS_4")
    private String CMS_DIAGNOSIS_4;
    @Column(name = "CMS_DIAGNOSIS_5")
    private String CMS_DIAGNOSIS_5;
    @Column(name = "CMS_DIAGNOSIS_6")
    private String CMS_DIAGNOSIS_6;
    @Column(name = "CMS_Elig_BEG_DATE_1")
    private Date CMS_Elig_BEG_DATE_1;
    @Column(name = "CMS_Elig_END_DATE_1")
    private Date CMS_Elig_END_DATE_1;
    @Column(name = "CMS_Elig_BEG_DATE_2")
    private Date CMS_Elig_BEG_DATE_2;
    @Column(name = "CMS_Elig_END_DATE_2")
    private Date CMS_Elig_END_DATE_2;
    @Column(name = "CMS_Elig_BEG_DATE_3")
    private Date CMS_Elig_BEG_DATE_3;
    @Column(name = "CMS_Elig_END_DATE_3")
    private Date CMS_Elig_END_DATE_3;
    @Column(name = "CMS_Elig_BEG_DATE_4")
    private Date CMS_Elig_BEG_DATE_4;
    @Column(name = "CMS_Elig_END_DATE_4")
    private Date CMS_Elig_END_DATE_4;
    @Column(name = "CMS_Elig_BEG_DATE_5")
    private Date CMS_Elig_BEG_DATE_5;
    @Column(name = "CMS_Elig_END_DATE_5")
    private Date CMS_Elig_END_DATE_5;
    @Column(name = "CMS_Elig_BEG_DATE_6")
    private Date CMS_Elig_BEG_DATE_6;
    @Column(name = "CMS_Elig_END_DATE_6")
    private Date CMS_Elig_END_DATE_6;
    @Column(name = "CMS_NUMBER_IN_HOUSEHOLD")
    private int CMS_NUMBER_IN_HOUSEHOLD;
    @Column(name = "CMS_MAIL_ADDRESS")
    private String CMS_MAIL_ADDRESS;
    @Column(name = "CMS_MAIL_CITY")
    private String CMS_MAIL_CITY;
    @Column(name = "CMS_MAIL_STATE")
    private String CMS_MAIL_STATE;
    @Column(name = "CMS_MAIL_ZIP")
    private int CMS_MAIL_ZIP;
    @Column(name = "CMS_MAIL_ZIP2")
    private int CMS_MAIL_ZIP2;
    @Column(name = "CMS_RES_ADDRESS")
    private String CMS_RES_ADDRESS;
    @Column(name = "CMS_RES_CITY")
    private String CMS_RES_CITY;
    @Column(name = "CMS_RES_STATE")
    private String CMS_RES_STATE;
    @Column(name = "CMS_RES_ZIP")
    private int CMS_RES_ZIP;
    @Column(name = "CMS_RES_ZIP2")
    private int CMS_RES_ZIP2;
    @Column(name = "CMS_3PTYL")
    private String CMS_3PTYL;

    public long getCMS_ID() {
        return CMS_ID;
    }

    public void setCMS_ID(long CMS_ID) {
        this.CMS_ID = CMS_ID;
    }

    public int getCMS_SSN() {
        return CMS_SSN;
    }

    public void setCMS_SSN(int CMS_SSN) {
        this.CMS_SSN = CMS_SSN;
    }

    public int getCMS_County_ID() {
        return CMS_County_ID;
    }

    public void setCMS_County_ID(int CMS_County_ID) {
        this.CMS_County_ID = CMS_County_ID;
    }

    public String getCMS_Status() {
        return CMS_Status;
    }

    public void setCMS_Status(String CMS_Status) {
        this.CMS_Status = CMS_Status;
    }

    public String getCMS_Name() {
        return CMS_Name;
    }

    public void setCMS_Name(String CMS_Name) {
        this.CMS_Name = CMS_Name;
    }

    public Date getCMS_DOB() {
        return CMS_DOB;
    }

    public void setCMS_DOB(Date CMS_DOB) {
        this.CMS_DOB = CMS_DOB;
    }

    public String getCMS_Race() {
        return CMS_Race;
    }

    public void setCMS_Race(String CMS_Race) {
        this.CMS_Race = CMS_Race;
    }

    public int getCMS_Sex() {
        return CMS_Sex;
    }

    public void setCMS_Sex(int CMS_Sex) {
        this.CMS_Sex = CMS_Sex;
    }

    public Date getCMS_DATE_OF_APPL() {
        return CMS_DATE_OF_APPL;
    }

    public void setCMS_DATE_OF_APPL(Date CMS_DATE_OF_APPL) {
        this.CMS_DATE_OF_APPL = CMS_DATE_OF_APPL;
    }

    public Date getCMS_REAPP_Date() {
        return CMS_REAPP_Date;
    }

    public void setCMS_REAPP_Date(Date CMS_REAPP_Date) {
        this.CMS_REAPP_Date = CMS_REAPP_Date;
    }

    public int getCMS_COMM_BASED_OFC_AREA() {
        return CMS_COMM_BASED_OFC_AREA;
    }

    public void setCMS_COMM_BASED_OFC_AREA(int CMS_COMM_BASED_OFC_AREA) {
        this.CMS_COMM_BASED_OFC_AREA = CMS_COMM_BASED_OFC_AREA;
    }

    public String getCMS_MEDICAID_STATUS() {
        return CMS_MEDICAID_STATUS;
    }

    public void setCMS_MEDICAID_STATUS(String CMS_MEDICAID_STATUS) {
        this.CMS_MEDICAID_STATUS = CMS_MEDICAID_STATUS;
    }

    public long getCMS_MEDICAID_NO() {
        return CMS_MEDICAID_NO;
    }

    public void setCMS_MEDICAID_NO(long CMS_MEDICAID_NO) {
        this.CMS_MEDICAID_NO = CMS_MEDICAID_NO;
    }

    public String getCMS_MEDICAID_CATEGORY() {
        return CMS_MEDICAID_CATEGORY;
    }

    public void setCMS_MEDICAID_CATEGORY(String CMS_MEDICAID_CATEGORY) {
        this.CMS_MEDICAID_CATEGORY = CMS_MEDICAID_CATEGORY;
    }

    public long getCMS_MEDICAID_PROV_NO() {
        return CMS_MEDICAID_PROV_NO;
    }

    public void setCMS_MEDICAID_PROV_NO(long CMS_MEDICAID_PROV_NO) {
        this.CMS_MEDICAID_PROV_NO = CMS_MEDICAID_PROV_NO;
    }

    public String getCMS_PRIMARY_PHYSICIAN() {
        return CMS_PRIMARY_PHYSICIAN;
    }

    public void setCMS_PRIMARY_PHYSICIAN(String CMS_PRIMARY_PHYSICIAN) {
        this.CMS_PRIMARY_PHYSICIAN = CMS_PRIMARY_PHYSICIAN;
    }

    public Date getCMS_PCP_EXEMPT_DATE() {
        return CMS_PCP_EXEMPT_DATE;
    }

    public void setCMS_PCP_EXEMPT_DATE(Date CMS_PCP_EXEMPT_DATE) {
        this.CMS_PCP_EXEMPT_DATE = CMS_PCP_EXEMPT_DATE;
    }

    public String getCMS_DIAGNOSIS_1() {
        return CMS_DIAGNOSIS_1;
    }

    public void setCMS_DIAGNOSIS_1(String CMS_DIAGNOSIS_1) {
        this.CMS_DIAGNOSIS_1 = CMS_DIAGNOSIS_1;
    }

    public String getCMS_DIAGNOSIS_2() {
        return CMS_DIAGNOSIS_2;
    }

    public void setCMS_DIAGNOSIS_2(String CMS_DIAGNOSIS_2) {
        this.CMS_DIAGNOSIS_2 = CMS_DIAGNOSIS_2;
    }

    public String getCMS_DIAGNOSIS_3() {
        return CMS_DIAGNOSIS_3;
    }

    public void setCMS_DIAGNOSIS_3(String CMS_DIAGNOSIS_3) {
        this.CMS_DIAGNOSIS_3 = CMS_DIAGNOSIS_3;
    }

    public String getCMS_DIAGNOSIS_4() {
        return CMS_DIAGNOSIS_4;
    }

    public void setCMS_DIAGNOSIS_4(String CMS_DIAGNOSIS_4) {
        this.CMS_DIAGNOSIS_4 = CMS_DIAGNOSIS_4;
    }

    public String getCMS_DIAGNOSIS_5() {
        return CMS_DIAGNOSIS_5;
    }

    public void setCMS_DIAGNOSIS_5(String CMS_DIAGNOSIS_5) {
        this.CMS_DIAGNOSIS_5 = CMS_DIAGNOSIS_5;
    }

    public String getCMS_DIAGNOSIS_6() {
        return CMS_DIAGNOSIS_6;
    }

    public void setCMS_DIAGNOSIS_6(String CMS_DIAGNOSIS_6) {
        this.CMS_DIAGNOSIS_6 = CMS_DIAGNOSIS_6;
    }

    public Date getCMS_Elig_BEG_DATE_1() {
        return CMS_Elig_BEG_DATE_1;
    }

    public void setCMS_Elig_BEG_DATE_1(Date CMS_Elig_BEG_DATE_1) {
        this.CMS_Elig_BEG_DATE_1 = CMS_Elig_BEG_DATE_1;
    }

    public Date getCMS_Elig_END_DATE_1() {
        return CMS_Elig_END_DATE_1;
    }

    public void setCMS_Elig_END_DATE_1(Date CMS_Elig_END_DATE_1) {
        this.CMS_Elig_END_DATE_1 = CMS_Elig_END_DATE_1;
    }

    public Date getCMS_Elig_BEG_DATE_2() {
        return CMS_Elig_BEG_DATE_2;
    }

    public void setCMS_Elig_BEG_DATE_2(Date CMS_Elig_BEG_DATE_2) {
        this.CMS_Elig_BEG_DATE_2 = CMS_Elig_BEG_DATE_2;
    }

    public Date getCMS_Elig_END_DATE_2() {
        return CMS_Elig_END_DATE_2;
    }

    public void setCMS_Elig_END_DATE_2(Date CMS_Elig_END_DATE_2) {
        this.CMS_Elig_END_DATE_2 = CMS_Elig_END_DATE_2;
    }

    public Date getCMS_Elig_BEG_DATE_3() {
        return CMS_Elig_BEG_DATE_3;
    }

    public void setCMS_Elig_BEG_DATE_3(Date CMS_Elig_BEG_DATE_3) {
        this.CMS_Elig_BEG_DATE_3 = CMS_Elig_BEG_DATE_3;
    }

    public Date getCMS_Elig_END_DATE_3() {
        return CMS_Elig_END_DATE_3;
    }

    public void setCMS_Elig_END_DATE_3(Date CMS_Elig_END_DATE_3) {
        this.CMS_Elig_END_DATE_3 = CMS_Elig_END_DATE_3;
    }

    public Date getCMS_Elig_BEG_DATE_4() {
        return CMS_Elig_BEG_DATE_4;
    }

    public void setCMS_Elig_BEG_DATE_4(Date CMS_Elig_BEG_DATE_4) {
        this.CMS_Elig_BEG_DATE_4 = CMS_Elig_BEG_DATE_4;
    }

    public Date getCMS_Elig_END_DATE_4() {
        return CMS_Elig_END_DATE_4;
    }

    public void setCMS_Elig_END_DATE_4(Date CMS_Elig_END_DATE_4) {
        this.CMS_Elig_END_DATE_4 = CMS_Elig_END_DATE_4;
    }

    public Date getCMS_Elig_BEG_DATE_5() {
        return CMS_Elig_BEG_DATE_5;
    }

    public void setCMS_Elig_BEG_DATE_5(Date CMS_Elig_BEG_DATE_5) {
        this.CMS_Elig_BEG_DATE_5 = CMS_Elig_BEG_DATE_5;
    }

    public Date getCMS_Elig_END_DATE_5() {
        return CMS_Elig_END_DATE_5;
    }

    public void setCMS_Elig_END_DATE_5(Date CMS_Elig_END_DATE_5) {
        this.CMS_Elig_END_DATE_5 = CMS_Elig_END_DATE_5;
    }

    public Date getCMS_Elig_BEG_DATE_6() {
        return CMS_Elig_BEG_DATE_6;
    }

    public void setCMS_Elig_BEG_DATE_6(Date CMS_Elig_BEG_DATE_6) {
        this.CMS_Elig_BEG_DATE_6 = CMS_Elig_BEG_DATE_6;
    }

    public Date getCMS_Elig_END_DATE_6() {
        return CMS_Elig_END_DATE_6;
    }

    public void setCMS_Elig_END_DATE_6(Date CMS_Elig_END_DATE_6) {
        this.CMS_Elig_END_DATE_6 = CMS_Elig_END_DATE_6;
    }

    public int getCMS_NUMBER_IN_HOUSEHOLD() {
        return CMS_NUMBER_IN_HOUSEHOLD;
    }

    public void setCMS_NUMBER_IN_HOUSEHOLD(int CMS_NUMBER_IN_HOUSEHOLD) {
        this.CMS_NUMBER_IN_HOUSEHOLD = CMS_NUMBER_IN_HOUSEHOLD;
    }

    public String getCMS_MAIL_ADDRESS() {
        return CMS_MAIL_ADDRESS;
    }

    public void setCMS_MAIL_ADDRESS(String CMS_MAIL_ADDRESS) {
        this.CMS_MAIL_ADDRESS = CMS_MAIL_ADDRESS;
    }

    public String getCMS_MAIL_CITY() {
        return CMS_MAIL_CITY;
    }

    public void setCMS_MAIL_CITY(String CMS_MAIL_CITY) {
        this.CMS_MAIL_CITY = CMS_MAIL_CITY;
    }

    public String getCMS_MAIL_STATE() {
        return CMS_MAIL_STATE;
    }

    public void setCMS_MAIL_STATE(String CMS_MAIL_STATE) {
        this.CMS_MAIL_STATE = CMS_MAIL_STATE;
    }

    public int getCMS_MAIL_ZIP() {
        return CMS_MAIL_ZIP;
    }

    public void setCMS_MAIL_ZIP(int CMS_MAIL_ZIP) {
        this.CMS_MAIL_ZIP = CMS_MAIL_ZIP;
    }

    public int getCMS_MAIL_ZIP2() {
        return CMS_MAIL_ZIP2;
    }

    public void setCMS_MAIL_ZIP2(int CMS_MAIL_ZIP2) {
        this.CMS_MAIL_ZIP2 = CMS_MAIL_ZIP2;
    }

    public String getCMS_RES_ADDRESS() {
        return CMS_RES_ADDRESS;
    }

    public void setCMS_RES_ADDRESS(String CMS_RES_ADDRESS) {
        this.CMS_RES_ADDRESS = CMS_RES_ADDRESS;
    }

    public String getCMS_RES_CITY() {
        return CMS_RES_CITY;
    }

    public void setCMS_RES_CITY(String CMS_RES_CITY) {
        this.CMS_RES_CITY = CMS_RES_CITY;
    }

    public String getCMS_RES_STATE() {
        return CMS_RES_STATE;
    }

    public void setCMS_RES_STATE(String CMS_RES_STATE) {
        this.CMS_RES_STATE = CMS_RES_STATE;
    }

    public int getCMS_RES_ZIP() {
        return CMS_RES_ZIP;
    }

    public void setCMS_RES_ZIP(int CMS_RES_ZIP) {
        this.CMS_RES_ZIP = CMS_RES_ZIP;
    }

    public int getCMS_RES_ZIP2() {
        return CMS_RES_ZIP2;
    }

    public void setCMS_RES_ZIP2(int CMS_RES_ZIP2) {
        this.CMS_RES_ZIP2 = CMS_RES_ZIP2;
    }

    public String getCMS_3PTYL() {
        return CMS_3PTYL;
    }

    public void setCMS_3PTYL(String CMS_3PTYL) {
        this.CMS_3PTYL = CMS_3PTYL;
    }
}
