package net.therap.model.ar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author jawad
 * @since 5/15/14  4:29 PM
 */
@Entity
@Table(name = "AR_DDS_CM_FINANCE")
public class DdsCmFinance {
    @Id
    @Column(name = "DDS_Id")
    private Long ddsId;
    @Column(name = "DDCM_MonthlyBills")
    private Long ddcmMonthlybills;
    @Column(name = "DDCM_ApplySobra")
    private String ddcmApplysobra;
    @Column(name = "DDCM_ApplyNeedy")
    private String ddcmApplyneedy;
    @Column(name = "DDCM_ApplyMedicaid")
    private String ddcmApplymedicaid;
    @Column(name = "DDCM_ApplySSI")
    private String ddcmApplyssi;
    @Column(name = "DDCM_CMF_NAME")
    private String ddcmCmfName;
    @Column(name = "DDCM_CMF_RELATION")
    private Integer ddcmCmfRelation;
    @Column(name = "DDCM_CMF_AGE")
    private String ddcmCmfAge;
    @Column(name = "DDCM_CMF_INCOME")
    private Long ddcmCmfIncome;
    @Column(name = "DDCM_CMF_SOURCE")
    private String ddcmCmfSource;
    @Column(name = "DDCM_CMF_NAME_1")
    private String ddcmCmfName1;
    @Column(name = "DDCM_CMF_RELATION_1")
    private Integer ddcmCmfRelation1;
    @Column(name = "DDCM_CMF_AGE_1")
    private String ddcmCmfAge1;
    @Column(name = "DDCM_CMF_INCOME_1")
    private Long ddcmCmfIncome1;
    @Column(name = "DDCM_CMF_SOURCE_1")
    private String ddcmCmfSource1;
    @Column(name = "DDCM_CMF_NAME_2")
    private String ddcmCmfName2;
    @Column(name = "DDCM_CMF_RELATION_2")
    private Integer ddcmCmfRelation2;
    @Column(name = "DDCM_CMF_AGE_2")
    private String ddcmCmfAge2;
    @Column(name = "DDCM_CMF_INCOME_2")
    private Long ddcmCmfIncome2;
    @Column(name = "DDCM_CMF_SOURCE_2")
    private String ddcmCmfSource2;
    @Column(name = "DDCM_CMF_NAME_3")
    private String ddcmCmfName3;
    @Column(name = "DDCM_CMF_RELATION_3")
    private Integer ddcmCmfRelation3;
    @Column(name = "DDCM_CMF_AGE_3")
    private String ddcmCmfAge3;
    @Column(name = "DDCM_CMF_INCOME_3")
    private Long ddcmCmfIncome3;
    @Column(name = "DDCM_CMF_SOURCE_3")
    private String ddcmCmfSource3;
    @Column(name = "DDCM_CMF_NAME_4")
    private String ddcmCmfName4;
    @Column(name = "DDCM_CMF_RELATION_4")
    private Integer ddcmCmfRelation4;
    @Column(name = "DDCM_CMF_AGE_4")
    private String ddcmCmfAge4;
    @Column(name = "DDCM_CMF_INCOME_4")
    private Long ddcmCmfIncome4;
    @Column(name = "DDCM_CMF_SOURCE_4")
    private String ddcmCmfSource4;
    @Column(name = "DDCM_CMF_NAME_5")
    private String ddcmCmfName5;
    @Column(name = "DDCM_CMF_RELATION_5")
    private Integer ddcmCmfRelation5;
    @Column(name = "DDCM_CMF_AGE_5")
    private String ddcmCmfAge5;
    @Column(name = "DDCM_CMF_INCOME_5")
    private Long ddcmCmfIncome5;
    @Column(name = "DDCM_CMF_SOURCE_5")
    private String ddcmCmfSource5;
    @Column(name = "DDCM_CMF_NAME_6")
    private String ddcmCmfName6;
    @Column(name = "DDCM_CMF_RELATION_6")
    private Integer ddcmCmfRelation6;
    @Column(name = "DDCM_CMF_AGE_6")
    private String ddcmCmfAge6;
    @Column(name = "DDCM_CMF_INCOME_6")
    private Long ddcmCmfIncome6;
    @Column(name = "DDCM_CMF_SOURCE_6")
    private String ddcmCmfSource6;
    @Column(name = "DDCM_CMF_NAME_7")
    private String ddcmCmfName7;
    @Column(name = "DDCM_CMF_RELATION_7")
    private Integer ddcmCmfRelation7;
    @Column(name = "DDCM_CMF_AGE_7")
    private String ddcmCmfAge7;
    @Column(name = "DDCM_CMF_INCOME_7")
    private Long ddcmCmfIncome7;
    @Column(name = "DDCM_CMF_SOURCE_7")
    private String ddcmCmfSource7;
    @Column(name = "DDCM_CMF_NAME_8")
    private String ddcmCmfName8;
    @Column(name = "DDCM_CMF_RELATION_8")
    private Integer ddcmCmfRelation8;
    @Column(name = "DDCM_CMF_AGE_8")
    private String ddcmCmfAge8;
    @Column(name = "DDCM_CMF_INCOME_8")
    private Long ddcmCmfIncome8;
    @Column(name = "DDCM_CMF_SOURCE_8")
    private String ddcmCmfSource8;
    @Column(name = "DDCM_DENY_RES_SSI")
    private Date ddcmDenyResSsi;
    @Column(name = "DDCM_DENY_RES_MEDICAID")
    private Date ddcmDenyResMedicaid;
    @Column(name = "DDCM_DENY_RES_5WEEK")
    private Date ddcmDenyRes5week;
    @Column(name = "DDCM_DENY_DIS_SSI")
    private Date ddcmDenyDisSsi;
    @Column(name = "DDCM_DENY_DIS_MEDICAID")
    private Date ddcmDenyDisMedicaid;
    @Column(name = "DDCM_SOBRA_DATE")
    private Date ddcmSobraDate;
    @Column(name = "DDCM_NEEDY_DATE")
    private Date ddcmNeedyDate;
    @Column(name = "DDCM_MEDICAID_DATE")
    private Date ddcmMedicaidDate;
    @Column(name = "DDCM_SSI_DATE")
    private Date ddcmSsiDate;
    @Column(name = "DDCM_PARENT_REFUSAL_DATE")
    private Date ddcmParentRefusalDate;

    public Long getDdsId() {
        return ddsId;
    }

    public void setDdsId(Long ddsId) {
        this.ddsId = ddsId;
    }

    public Long getDdcmMonthlybills() {
        return ddcmMonthlybills;
    }

    public void setDdcmMonthlybills(Long ddcmMonthlybills) {
        this.ddcmMonthlybills = ddcmMonthlybills;
    }

    public String getDdcmApplysobra() {
        return ddcmApplysobra;
    }

    public void setDdcmApplysobra(String ddcmApplysobra) {
        this.ddcmApplysobra = ddcmApplysobra;
    }

    public String getDdcmApplyneedy() {
        return ddcmApplyneedy;
    }

    public void setDdcmApplyneedy(String ddcmApplyneedy) {
        this.ddcmApplyneedy = ddcmApplyneedy;
    }

    public String getDdcmApplymedicaid() {
        return ddcmApplymedicaid;
    }

    public void setDdcmApplymedicaid(String ddcmApplymedicaid) {
        this.ddcmApplymedicaid = ddcmApplymedicaid;
    }

    public String getDdcmApplyssi() {
        return ddcmApplyssi;
    }

    public void setDdcmApplyssi(String ddcmApplyssi) {
        this.ddcmApplyssi = ddcmApplyssi;
    }

    public String getDdcmCmfName() {
        return ddcmCmfName;
    }

    public void setDdcmCmfName(String ddcmCmfName) {
        this.ddcmCmfName = ddcmCmfName;
    }

    public Integer getDdcmCmfRelation() {
        return ddcmCmfRelation;
    }

    public void setDdcmCmfRelation(Integer ddcmCmfRelation) {
        this.ddcmCmfRelation = ddcmCmfRelation;
    }

    public String getDdcmCmfAge() {
        return ddcmCmfAge;
    }

    public void setDdcmCmfAge(String ddcmCmfAge) {
        this.ddcmCmfAge = ddcmCmfAge;
    }

    public Long getDdcmCmfIncome() {
        return ddcmCmfIncome;
    }

    public void setDdcmCmfIncome(Long ddcmCmfIncome) {
        this.ddcmCmfIncome = ddcmCmfIncome;
    }

    public String getDdcmCmfSource() {
        return ddcmCmfSource;
    }

    public void setDdcmCmfSource(String ddcmCmfSource) {
        this.ddcmCmfSource = ddcmCmfSource;
    }

    public String getDdcmCmfName1() {
        return ddcmCmfName1;
    }

    public void setDdcmCmfName1(String ddcmCmfName1) {
        this.ddcmCmfName1 = ddcmCmfName1;
    }

    public Integer getDdcmCmfRelation1() {
        return ddcmCmfRelation1;
    }

    public void setDdcmCmfRelation1(Integer ddcmCmfRelation1) {
        this.ddcmCmfRelation1 = ddcmCmfRelation1;
    }

    public String getDdcmCmfAge1() {
        return ddcmCmfAge1;
    }

    public void setDdcmCmfAge1(String ddcmCmfAge1) {
        this.ddcmCmfAge1 = ddcmCmfAge1;
    }

    public Long getDdcmCmfIncome1() {
        return ddcmCmfIncome1;
    }

    public void setDdcmCmfIncome1(Long ddcmCmfIncome1) {
        this.ddcmCmfIncome1 = ddcmCmfIncome1;
    }

    public String getDdcmCmfSource1() {
        return ddcmCmfSource1;
    }

    public void setDdcmCmfSource1(String ddcmCmfSource1) {
        this.ddcmCmfSource1 = ddcmCmfSource1;
    }

    public String getDdcmCmfName2() {
        return ddcmCmfName2;
    }

    public void setDdcmCmfName2(String ddcmCmfName2) {
        this.ddcmCmfName2 = ddcmCmfName2;
    }

    public Integer getDdcmCmfRelation2() {
        return ddcmCmfRelation2;
    }

    public void setDdcmCmfRelation2(Integer ddcmCmfRelation2) {
        this.ddcmCmfRelation2 = ddcmCmfRelation2;
    }

    public String getDdcmCmfAge2() {
        return ddcmCmfAge2;
    }

    public void setDdcmCmfAge2(String ddcmCmfAge2) {
        this.ddcmCmfAge2 = ddcmCmfAge2;
    }

    public Long getDdcmCmfIncome2() {
        return ddcmCmfIncome2;
    }

    public void setDdcmCmfIncome2(Long ddcmCmfIncome2) {
        this.ddcmCmfIncome2 = ddcmCmfIncome2;
    }

    public String getDdcmCmfSource2() {
        return ddcmCmfSource2;
    }

    public void setDdcmCmfSource2(String ddcmCmfSource2) {
        this.ddcmCmfSource2 = ddcmCmfSource2;
    }

    public String getDdcmCmfName3() {
        return ddcmCmfName3;
    }

    public void setDdcmCmfName3(String ddcmCmfName3) {
        this.ddcmCmfName3 = ddcmCmfName3;
    }

    public Integer getDdcmCmfRelation3() {
        return ddcmCmfRelation3;
    }

    public void setDdcmCmfRelation3(Integer ddcmCmfRelation3) {
        this.ddcmCmfRelation3 = ddcmCmfRelation3;
    }

    public String getDdcmCmfAge3() {
        return ddcmCmfAge3;
    }

    public void setDdcmCmfAge3(String ddcmCmfAge3) {
        this.ddcmCmfAge3 = ddcmCmfAge3;
    }

    public Long getDdcmCmfIncome3() {
        return ddcmCmfIncome3;
    }

    public void setDdcmCmfIncome3(Long ddcmCmfIncome3) {
        this.ddcmCmfIncome3 = ddcmCmfIncome3;
    }

    public String getDdcmCmfSource3() {
        return ddcmCmfSource3;
    }

    public void setDdcmCmfSource3(String ddcmCmfSource3) {
        this.ddcmCmfSource3 = ddcmCmfSource3;
    }

    public String getDdcmCmfName4() {
        return ddcmCmfName4;
    }

    public void setDdcmCmfName4(String ddcmCmfName4) {
        this.ddcmCmfName4 = ddcmCmfName4;
    }

    public Integer getDdcmCmfRelation4() {
        return ddcmCmfRelation4;
    }

    public void setDdcmCmfRelation4(Integer ddcmCmfRelation4) {
        this.ddcmCmfRelation4 = ddcmCmfRelation4;
    }

    public String getDdcmCmfAge4() {
        return ddcmCmfAge4;
    }

    public void setDdcmCmfAge4(String ddcmCmfAge4) {
        this.ddcmCmfAge4 = ddcmCmfAge4;
    }

    public Long getDdcmCmfIncome4() {
        return ddcmCmfIncome4;
    }

    public void setDdcmCmfIncome4(Long ddcmCmfIncome4) {
        this.ddcmCmfIncome4 = ddcmCmfIncome4;
    }

    public String getDdcmCmfSource4() {
        return ddcmCmfSource4;
    }

    public void setDdcmCmfSource4(String ddcmCmfSource4) {
        this.ddcmCmfSource4 = ddcmCmfSource4;
    }

    public String getDdcmCmfName5() {
        return ddcmCmfName5;
    }

    public void setDdcmCmfName5(String ddcmCmfName5) {
        this.ddcmCmfName5 = ddcmCmfName5;
    }

    public Integer getDdcmCmfRelation5() {
        return ddcmCmfRelation5;
    }

    public void setDdcmCmfRelation5(Integer ddcmCmfRelation5) {
        this.ddcmCmfRelation5 = ddcmCmfRelation5;
    }

    public String getDdcmCmfAge5() {
        return ddcmCmfAge5;
    }

    public void setDdcmCmfAge5(String ddcmCmfAge5) {
        this.ddcmCmfAge5 = ddcmCmfAge5;
    }

    public Long getDdcmCmfIncome5() {
        return ddcmCmfIncome5;
    }

    public void setDdcmCmfIncome5(Long ddcmCmfIncome5) {
        this.ddcmCmfIncome5 = ddcmCmfIncome5;
    }

    public String getDdcmCmfSource5() {
        return ddcmCmfSource5;
    }

    public void setDdcmCmfSource5(String ddcmCmfSource5) {
        this.ddcmCmfSource5 = ddcmCmfSource5;
    }

    public String getDdcmCmfName6() {
        return ddcmCmfName6;
    }

    public void setDdcmCmfName6(String ddcmCmfName6) {
        this.ddcmCmfName6 = ddcmCmfName6;
    }

    public Integer getDdcmCmfRelation6() {
        return ddcmCmfRelation6;
    }

    public void setDdcmCmfRelation6(Integer ddcmCmfRelation6) {
        this.ddcmCmfRelation6 = ddcmCmfRelation6;
    }

    public String getDdcmCmfAge6() {
        return ddcmCmfAge6;
    }

    public void setDdcmCmfAge6(String ddcmCmfAge6) {
        this.ddcmCmfAge6 = ddcmCmfAge6;
    }

    public Long getDdcmCmfIncome6() {
        return ddcmCmfIncome6;
    }

    public void setDdcmCmfIncome6(Long ddcmCmfIncome6) {
        this.ddcmCmfIncome6 = ddcmCmfIncome6;
    }

    public String getDdcmCmfSource6() {
        return ddcmCmfSource6;
    }

    public void setDdcmCmfSource6(String ddcmCmfSource6) {
        this.ddcmCmfSource6 = ddcmCmfSource6;
    }

    public String getDdcmCmfName7() {
        return ddcmCmfName7;
    }

    public void setDdcmCmfName7(String ddcmCmfName7) {
        this.ddcmCmfName7 = ddcmCmfName7;
    }

    public Integer getDdcmCmfRelation7() {
        return ddcmCmfRelation7;
    }

    public void setDdcmCmfRelation7(Integer ddcmCmfRelation7) {
        this.ddcmCmfRelation7 = ddcmCmfRelation7;
    }

    public String getDdcmCmfAge7() {
        return ddcmCmfAge7;
    }

    public void setDdcmCmfAge7(String ddcmCmfAge7) {
        this.ddcmCmfAge7 = ddcmCmfAge7;
    }

    public Long getDdcmCmfIncome7() {
        return ddcmCmfIncome7;
    }

    public void setDdcmCmfIncome7(Long ddcmCmfIncome7) {
        this.ddcmCmfIncome7 = ddcmCmfIncome7;
    }

    public String getDdcmCmfSource7() {
        return ddcmCmfSource7;
    }

    public void setDdcmCmfSource7(String ddcmCmfSource7) {
        this.ddcmCmfSource7 = ddcmCmfSource7;
    }

    public String getDdcmCmfName8() {
        return ddcmCmfName8;
    }

    public void setDdcmCmfName8(String ddcmCmfName8) {
        this.ddcmCmfName8 = ddcmCmfName8;
    }

    public Integer getDdcmCmfRelation8() {
        return ddcmCmfRelation8;
    }

    public void setDdcmCmfRelation8(Integer ddcmCmfRelation8) {
        this.ddcmCmfRelation8 = ddcmCmfRelation8;
    }

    public String getDdcmCmfAge8() {
        return ddcmCmfAge8;
    }

    public void setDdcmCmfAge8(String ddcmCmfAge8) {
        this.ddcmCmfAge8 = ddcmCmfAge8;
    }

    public Long getDdcmCmfIncome8() {
        return ddcmCmfIncome8;
    }

    public void setDdcmCmfIncome8(Long ddcmCmfIncome8) {
        this.ddcmCmfIncome8 = ddcmCmfIncome8;
    }

    public String getDdcmCmfSource8() {
        return ddcmCmfSource8;
    }

    public void setDdcmCmfSource8(String ddcmCmfSource8) {
        this.ddcmCmfSource8 = ddcmCmfSource8;
    }

    public Date getDdcmDenyResSsi() {
        return ddcmDenyResSsi;
    }

    public void setDdcmDenyResSsi(Date ddcmDenyResSsi) {
        this.ddcmDenyResSsi = ddcmDenyResSsi;
    }

    public Date getDdcmDenyResMedicaid() {
        return ddcmDenyResMedicaid;
    }

    public void setDdcmDenyResMedicaid(Date ddcmDenyResMedicaid) {
        this.ddcmDenyResMedicaid = ddcmDenyResMedicaid;
    }

    public Date getDdcmDenyRes5week() {
        return ddcmDenyRes5week;
    }

    public void setDdcmDenyRes5week(Date ddcmDenyRes5week) {
        this.ddcmDenyRes5week = ddcmDenyRes5week;
    }

    public Date getDdcmDenyDisSsi() {
        return ddcmDenyDisSsi;
    }

    public void setDdcmDenyDisSsi(Date ddcmDenyDisSsi) {
        this.ddcmDenyDisSsi = ddcmDenyDisSsi;
    }

    public Date getDdcmDenyDisMedicaid() {
        return ddcmDenyDisMedicaid;
    }

    public void setDdcmDenyDisMedicaid(Date ddcmDenyDisMedicaid) {
        this.ddcmDenyDisMedicaid = ddcmDenyDisMedicaid;
    }

    public Date getDdcmSobraDate() {
        return ddcmSobraDate;
    }

    public void setDdcmSobraDate(Date ddcmSobraDate) {
        this.ddcmSobraDate = ddcmSobraDate;
    }

    public Date getDdcmNeedyDate() {
        return ddcmNeedyDate;
    }

    public void setDdcmNeedyDate(Date ddcmNeedyDate) {
        this.ddcmNeedyDate = ddcmNeedyDate;
    }

    public Date getDdcmMedicaidDate() {
        return ddcmMedicaidDate;
    }

    public void setDdcmMedicaidDate(Date ddcmMedicaidDate) {
        this.ddcmMedicaidDate = ddcmMedicaidDate;
    }

    public Date getDdcmSsiDate() {
        return ddcmSsiDate;
    }

    public void setDdcmSsiDate(Date ddcmSsiDate) {
        this.ddcmSsiDate = ddcmSsiDate;
    }

    public Date getDdcmParentRefusalDate() {
        return ddcmParentRefusalDate;
    }

    public void setDdcmParentRefusalDate(Date ddcmParentRefusalDate) {
        this.ddcmParentRefusalDate = ddcmParentRefusalDate;
    }
}
