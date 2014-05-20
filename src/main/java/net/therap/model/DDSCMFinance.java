package net.therap.model;

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
@Table(name = "AR_CMS_DDSCMFINANCE")
public class DDSCMFinance {
    @Id
    @Column(name = "DDS_Id")
    private Integer DDS_Id;
    @Column(name = "DDCM_MonthlyBills")
    private Long DDCM_MonthlyBills;
    @Column(name = "DDCM_ApplySobra")
    private String DDCM_ApplySobra;
    @Column(name = "DDCM_ApplyNeedy")
    private String DDCM_ApplyNeedy;
    @Column(name = "DDCM_ApplyMedicaid")
    private String DDCM_ApplyMedicaid;
    @Column(name = "DDCM_ApplySSI")
    private String DDCM_ApplySSI;
    @Column(name = "DDCM_CMF_NAME")
    private String DDCM_CMF_NAME;
    @Column(name = "DDCM_CMF_RELATION")
    private Integer DDCM_CMF_RELATION;
    @Column(name = "DDCM_CMF_AGE")
    private String DDCM_CMF_AGE;
    @Column(name = "DDCM_CMF_INCOME")
    private Long DDCM_CMF_INCOME;
    @Column(name = "DDCM_CMF_SOURCE")
    private String DDCM_CMF_SOURCE;
    @Column(name = "DDCM_CMF_NAME_1")
    private String DDCM_CMF_NAME_1;
    @Column(name = "DDCM_CMF_RELATION_1")
    private Integer DDCM_CMF_RELATION_1;
    @Column(name = "DDCM_CMF_AGE_1")
    private String DDCM_CMF_AGE_1;
    @Column(name = "DDCM_CMF_INCOME_1")
    private Long DDCM_CMF_INCOME_1;
    @Column(name = "DDCM_CMF_SOURCE_1")
    private String DDCM_CMF_SOURCE_1;
    @Column(name = "DDCM_CMF_NAME_2")
    private String DDCM_CMF_NAME_2;
    @Column(name = "DDCM_CMF_RELATION_2")
    private Integer DDCM_CMF_RELATION_2;
    @Column(name = "DDCM_CMF_AGE_2")
    private String DDCM_CMF_AGE_2;
    @Column(name = "DDCM_CMF_INCOME_2")
    private Long DDCM_CMF_INCOME_2;
    @Column(name = "DDCM_CMF_SOURCE_2")
    private String DDCM_CMF_SOURCE_2;
    @Column(name = "DDCM_CMF_NAME_3")
    private String DDCM_CMF_NAME_3;
    @Column(name = "DDCM_CMF_RELATION_3")
    private Integer DDCM_CMF_RELATION_3;
    @Column(name = "DDCM_CMF_AGE_3")
    private String DDCM_CMF_AGE_3;
    @Column(name = "DDCM_CMF_INCOME_3")
    private Long DDCM_CMF_INCOME_3;
    @Column(name = "DDCM_CMF_SOURCE_3")
    private String DDCM_CMF_SOURCE_3;
    @Column(name = "DDCM_CMF_NAME_4")
    private String DDCM_CMF_NAME_4;
    @Column(name = "DDCM_CMF_RELATION_4")
    private Integer DDCM_CMF_RELATION_4;
    @Column(name = "DDCM_CMF_AGE_4")
    private String DDCM_CMF_AGE_4;
    @Column(name = "DDCM_CMF_INCOME_4")
    private Long DDCM_CMF_INCOME_4;
    @Column(name = "DDCM_CMF_SOURCE_4")
    private String DDCM_CMF_SOURCE_4;
    @Column(name = "DDCM_CMF_NAME_5")
    private String DDCM_CMF_NAME_5;
    @Column(name = "DDCM_CMF_RELATION_5")
    private Integer DDCM_CMF_RELATION_5;
    @Column(name = "DDCM_CMF_AGE_5")
    private String DDCM_CMF_AGE_5;
    @Column(name = "DDCM_CMF_INCOME_5")
    private Long DDCM_CMF_INCOME_5;
    @Column(name = "DDCM_CMF_SOURCE_5")
    private String DDCM_CMF_SOURCE_5;
    @Column(name = "DDCM_CMF_NAME_6")
    private String DDCM_CMF_NAME_6;
    @Column(name = "DDCM_CMF_RELATION_6")
    private Integer DDCM_CMF_RELATION_6;
    @Column(name = "DDCM_CMF_AGE_6")
    private String DDCM_CMF_AGE_6;
    @Column(name = "DDCM_CMF_INCOME_6")
    private Long DDCM_CMF_INCOME_6;
    @Column(name = "DDCM_CMF_SOURCE_6")
    private String DDCM_CMF_SOURCE_6;
    @Column(name = "DDCM_CMF_NAME_7")
    private String DDCM_CMF_NAME_7;
    @Column(name = "DDCM_CMF_RELATION_7")
    private Integer DDCM_CMF_RELATION_7;
    @Column(name = "DDCM_CMF_AGE_7")
    private String DDCM_CMF_AGE_7;
    @Column(name = "DDCM_CMF_INCOME_7")
    private Long DDCM_CMF_INCOME_7;
    @Column(name = "DDCM_CMF_SOURCE_7")
    private String DDCM_CMF_SOURCE_7;
    @Column(name = "DDCM_CMF_NAME_8")
    private String DDCM_CMF_NAME_8;
    @Column(name = "DDCM_CMF_RELATION_8")
    private Integer DDCM_CMF_RELATION_8;
    @Column(name = "DDCM_CMF_AGE_8")
    private String DDCM_CMF_AGE_8;
    @Column(name = "DDCM_CMF_INCOME_8")
    private Long DDCM_CMF_INCOME_8;
    @Column(name = "DDCM_CMF_SOURCE_8")
    private String DDCM_CMF_SOURCE_8;
    @Column(name = "DDCM_DENY_RES_SSI")
    private Date DDCM_DENY_RES_SSI;
    @Column(name = "DDCM_DENY_RES_MEDICAID")
    private Date DDCM_DENY_RES_MEDICAID;
    @Column(name = "DDCM_DENY_RES_5WEEK")
    private Date DDCM_DENY_RES_5WEEK;
    @Column(name = "DDCM_DENY_DIS_SSI")
    private Date DDCM_DENY_DIS_SSI;
    @Column(name = "DDCM_DENY_DIS_MEDICAID")
    private Date DDCM_DENY_DIS_MEDICAID;
    @Column(name = "DDCM_SOBRA_DATE")
    private Date DDCM_SOBRA_DATE;
    @Column(name = "DDCM_NEEDY_DATE")
    private Date DDCM_NEEDY_DATE;
    @Column(name = "DDCM_MEDICAID_DATE")
    private Date DDCM_MEDICAID_DATE;
    @Column(name = "DDCM_SSI_DATE")
    private Date DDCM_SSI_DATE;
    @Column(name = "DDCM_PARENT_REFUSAL_DATE")
    private Date DDCM_PARENT_REFUSAL_DATE;

    public Integer getDDS_Id() {
        return DDS_Id;
    }

    public void setDDS_Id(Integer DDS_Id) {
        this.DDS_Id = DDS_Id;
    }

    public Long getDDCM_MonthlyBills() {
        return DDCM_MonthlyBills;
    }

    public void setDDCM_MonthlyBills(Long DDCM_MonthlyBills) {
        this.DDCM_MonthlyBills = DDCM_MonthlyBills;
    }

    public String getDDCM_ApplySobra() {
        return DDCM_ApplySobra;
    }

    public void setDDCM_ApplySobra(String DDCM_ApplySobra) {
        this.DDCM_ApplySobra = DDCM_ApplySobra;
    }

    public String getDDCM_ApplyNeedy() {
        return DDCM_ApplyNeedy;
    }

    public void setDDCM_ApplyNeedy(String DDCM_ApplyNeedy) {
        this.DDCM_ApplyNeedy = DDCM_ApplyNeedy;
    }

    public String getDDCM_ApplyMedicaid() {
        return DDCM_ApplyMedicaid;
    }

    public void setDDCM_ApplyMedicaid(String DDCM_ApplyMedicaid) {
        this.DDCM_ApplyMedicaid = DDCM_ApplyMedicaid;
    }

    public String getDDCM_ApplySSI() {
        return DDCM_ApplySSI;
    }

    public void setDDCM_ApplySSI(String DDCM_ApplySSI) {
        this.DDCM_ApplySSI = DDCM_ApplySSI;
    }

    public String getDDCM_CMF_NAME() {
        return DDCM_CMF_NAME;
    }

    public void setDDCM_CMF_NAME(String DDCM_CMF_NAME) {
        this.DDCM_CMF_NAME = DDCM_CMF_NAME;
    }

    public Integer getDDCM_CMF_RELATION() {
        return DDCM_CMF_RELATION;
    }

    public void setDDCM_CMF_RELATION(Integer DDCM_CMF_RELATION) {
        this.DDCM_CMF_RELATION = DDCM_CMF_RELATION;
    }

    public String getDDCM_CMF_AGE() {
        return DDCM_CMF_AGE;
    }

    public void setDDCM_CMF_AGE(String DDCM_CMF_AGE) {
        this.DDCM_CMF_AGE = DDCM_CMF_AGE;
    }

    public Long getDDCM_CMF_INCOME() {
        return DDCM_CMF_INCOME;
    }

    public void setDDCM_CMF_INCOME(Long DDCM_CMF_INCOME) {
        this.DDCM_CMF_INCOME = DDCM_CMF_INCOME;
    }

    public String getDDCM_CMF_SOURCE() {
        return DDCM_CMF_SOURCE;
    }

    public void setDDCM_CMF_SOURCE(String DDCM_CMF_SOURCE) {
        this.DDCM_CMF_SOURCE = DDCM_CMF_SOURCE;
    }

    public String getDDCM_CMF_NAME_1() {
        return DDCM_CMF_NAME_1;
    }

    public void setDDCM_CMF_NAME_1(String DDCM_CMF_NAME_1) {
        this.DDCM_CMF_NAME_1 = DDCM_CMF_NAME_1;
    }

    public Integer getDDCM_CMF_RELATION_1() {
        return DDCM_CMF_RELATION_1;
    }

    public void setDDCM_CMF_RELATION_1(Integer DDCM_CMF_RELATION_1) {
        this.DDCM_CMF_RELATION_1 = DDCM_CMF_RELATION_1;
    }

    public String getDDCM_CMF_AGE_1() {
        return DDCM_CMF_AGE_1;
    }

    public void setDDCM_CMF_AGE_1(String DDCM_CMF_AGE_1) {
        this.DDCM_CMF_AGE_1 = DDCM_CMF_AGE_1;
    }

    public Long getDDCM_CMF_INCOME_1() {
        return DDCM_CMF_INCOME_1;
    }

    public void setDDCM_CMF_INCOME_1(Long DDCM_CMF_INCOME_1) {
        this.DDCM_CMF_INCOME_1 = DDCM_CMF_INCOME_1;
    }

    public String getDDCM_CMF_SOURCE_1() {
        return DDCM_CMF_SOURCE_1;
    }

    public void setDDCM_CMF_SOURCE_1(String DDCM_CMF_SOURCE_1) {
        this.DDCM_CMF_SOURCE_1 = DDCM_CMF_SOURCE_1;
    }

    public String getDDCM_CMF_NAME_2() {
        return DDCM_CMF_NAME_2;
    }

    public void setDDCM_CMF_NAME_2(String DDCM_CMF_NAME_2) {
        this.DDCM_CMF_NAME_2 = DDCM_CMF_NAME_2;
    }

    public Integer getDDCM_CMF_RELATION_2() {
        return DDCM_CMF_RELATION_2;
    }

    public void setDDCM_CMF_RELATION_2(Integer DDCM_CMF_RELATION_2) {
        this.DDCM_CMF_RELATION_2 = DDCM_CMF_RELATION_2;
    }

    public String getDDCM_CMF_AGE_2() {
        return DDCM_CMF_AGE_2;
    }

    public void setDDCM_CMF_AGE_2(String DDCM_CMF_AGE_2) {
        this.DDCM_CMF_AGE_2 = DDCM_CMF_AGE_2;
    }

    public Long getDDCM_CMF_INCOME_2() {
        return DDCM_CMF_INCOME_2;
    }

    public void setDDCM_CMF_INCOME_2(Long DDCM_CMF_INCOME_2) {
        this.DDCM_CMF_INCOME_2 = DDCM_CMF_INCOME_2;
    }

    public String getDDCM_CMF_SOURCE_2() {
        return DDCM_CMF_SOURCE_2;
    }

    public void setDDCM_CMF_SOURCE_2(String DDCM_CMF_SOURCE_2) {
        this.DDCM_CMF_SOURCE_2 = DDCM_CMF_SOURCE_2;
    }

    public String getDDCM_CMF_NAME_3() {
        return DDCM_CMF_NAME_3;
    }

    public void setDDCM_CMF_NAME_3(String DDCM_CMF_NAME_3) {
        this.DDCM_CMF_NAME_3 = DDCM_CMF_NAME_3;
    }

    public Integer getDDCM_CMF_RELATION_3() {
        return DDCM_CMF_RELATION_3;
    }

    public void setDDCM_CMF_RELATION_3(Integer DDCM_CMF_RELATION_3) {
        this.DDCM_CMF_RELATION_3 = DDCM_CMF_RELATION_3;
    }

    public String getDDCM_CMF_AGE_3() {
        return DDCM_CMF_AGE_3;
    }

    public void setDDCM_CMF_AGE_3(String DDCM_CMF_AGE_3) {
        this.DDCM_CMF_AGE_3 = DDCM_CMF_AGE_3;
    }

    public Long getDDCM_CMF_INCOME_3() {
        return DDCM_CMF_INCOME_3;
    }

    public void setDDCM_CMF_INCOME_3(Long DDCM_CMF_INCOME_3) {
        this.DDCM_CMF_INCOME_3 = DDCM_CMF_INCOME_3;
    }

    public String getDDCM_CMF_SOURCE_3() {
        return DDCM_CMF_SOURCE_3;
    }

    public void setDDCM_CMF_SOURCE_3(String DDCM_CMF_SOURCE_3) {
        this.DDCM_CMF_SOURCE_3 = DDCM_CMF_SOURCE_3;
    }

    public String getDDCM_CMF_NAME_4() {
        return DDCM_CMF_NAME_4;
    }

    public void setDDCM_CMF_NAME_4(String DDCM_CMF_NAME_4) {
        this.DDCM_CMF_NAME_4 = DDCM_CMF_NAME_4;
    }

    public Integer getDDCM_CMF_RELATION_4() {
        return DDCM_CMF_RELATION_4;
    }

    public void setDDCM_CMF_RELATION_4(Integer DDCM_CMF_RELATION_4) {
        this.DDCM_CMF_RELATION_4 = DDCM_CMF_RELATION_4;
    }

    public String getDDCM_CMF_AGE_4() {
        return DDCM_CMF_AGE_4;
    }

    public void setDDCM_CMF_AGE_4(String DDCM_CMF_AGE_4) {
        this.DDCM_CMF_AGE_4 = DDCM_CMF_AGE_4;
    }

    public Long getDDCM_CMF_INCOME_4() {
        return DDCM_CMF_INCOME_4;
    }

    public void setDDCM_CMF_INCOME_4(Long DDCM_CMF_INCOME_4) {
        this.DDCM_CMF_INCOME_4 = DDCM_CMF_INCOME_4;
    }

    public String getDDCM_CMF_SOURCE_4() {
        return DDCM_CMF_SOURCE_4;
    }

    public void setDDCM_CMF_SOURCE_4(String DDCM_CMF_SOURCE_4) {
        this.DDCM_CMF_SOURCE_4 = DDCM_CMF_SOURCE_4;
    }

    public String getDDCM_CMF_NAME_5() {
        return DDCM_CMF_NAME_5;
    }

    public void setDDCM_CMF_NAME_5(String DDCM_CMF_NAME_5) {
        this.DDCM_CMF_NAME_5 = DDCM_CMF_NAME_5;
    }

    public Integer getDDCM_CMF_RELATION_5() {
        return DDCM_CMF_RELATION_5;
    }

    public void setDDCM_CMF_RELATION_5(Integer DDCM_CMF_RELATION_5) {
        this.DDCM_CMF_RELATION_5 = DDCM_CMF_RELATION_5;
    }

    public String getDDCM_CMF_AGE_5() {
        return DDCM_CMF_AGE_5;
    }

    public void setDDCM_CMF_AGE_5(String DDCM_CMF_AGE_5) {
        this.DDCM_CMF_AGE_5 = DDCM_CMF_AGE_5;
    }

    public Long getDDCM_CMF_INCOME_5() {
        return DDCM_CMF_INCOME_5;
    }

    public void setDDCM_CMF_INCOME_5(Long DDCM_CMF_INCOME_5) {
        this.DDCM_CMF_INCOME_5 = DDCM_CMF_INCOME_5;
    }

    public String getDDCM_CMF_SOURCE_5() {
        return DDCM_CMF_SOURCE_5;
    }

    public void setDDCM_CMF_SOURCE_5(String DDCM_CMF_SOURCE_5) {
        this.DDCM_CMF_SOURCE_5 = DDCM_CMF_SOURCE_5;
    }

    public String getDDCM_CMF_NAME_6() {
        return DDCM_CMF_NAME_6;
    }

    public void setDDCM_CMF_NAME_6(String DDCM_CMF_NAME_6) {
        this.DDCM_CMF_NAME_6 = DDCM_CMF_NAME_6;
    }

    public Integer getDDCM_CMF_RELATION_6() {
        return DDCM_CMF_RELATION_6;
    }

    public void setDDCM_CMF_RELATION_6(Integer DDCM_CMF_RELATION_6) {
        this.DDCM_CMF_RELATION_6 = DDCM_CMF_RELATION_6;
    }

    public String getDDCM_CMF_AGE_6() {
        return DDCM_CMF_AGE_6;
    }

    public void setDDCM_CMF_AGE_6(String DDCM_CMF_AGE_6) {
        this.DDCM_CMF_AGE_6 = DDCM_CMF_AGE_6;
    }

    public Long getDDCM_CMF_INCOME_6() {
        return DDCM_CMF_INCOME_6;
    }

    public void setDDCM_CMF_INCOME_6(Long DDCM_CMF_INCOME_6) {
        this.DDCM_CMF_INCOME_6 = DDCM_CMF_INCOME_6;
    }

    public String getDDCM_CMF_SOURCE_6() {
        return DDCM_CMF_SOURCE_6;
    }

    public void setDDCM_CMF_SOURCE_6(String DDCM_CMF_SOURCE_6) {
        this.DDCM_CMF_SOURCE_6 = DDCM_CMF_SOURCE_6;
    }

    public String getDDCM_CMF_NAME_7() {
        return DDCM_CMF_NAME_7;
    }

    public void setDDCM_CMF_NAME_7(String DDCM_CMF_NAME_7) {
        this.DDCM_CMF_NAME_7 = DDCM_CMF_NAME_7;
    }

    public Integer getDDCM_CMF_RELATION_7() {
        return DDCM_CMF_RELATION_7;
    }

    public void setDDCM_CMF_RELATION_7(Integer DDCM_CMF_RELATION_7) {
        this.DDCM_CMF_RELATION_7 = DDCM_CMF_RELATION_7;
    }

    public String getDDCM_CMF_AGE_7() {
        return DDCM_CMF_AGE_7;
    }

    public void setDDCM_CMF_AGE_7(String DDCM_CMF_AGE_7) {
        this.DDCM_CMF_AGE_7 = DDCM_CMF_AGE_7;
    }

    public Long getDDCM_CMF_INCOME_7() {
        return DDCM_CMF_INCOME_7;
    }

    public void setDDCM_CMF_INCOME_7(Long DDCM_CMF_INCOME_7) {
        this.DDCM_CMF_INCOME_7 = DDCM_CMF_INCOME_7;
    }

    public String getDDCM_CMF_SOURCE_7() {
        return DDCM_CMF_SOURCE_7;
    }

    public void setDDCM_CMF_SOURCE_7(String DDCM_CMF_SOURCE_7) {
        this.DDCM_CMF_SOURCE_7 = DDCM_CMF_SOURCE_7;
    }

    public String getDDCM_CMF_NAME_8() {
        return DDCM_CMF_NAME_8;
    }

    public void setDDCM_CMF_NAME_8(String DDCM_CMF_NAME_8) {
        this.DDCM_CMF_NAME_8 = DDCM_CMF_NAME_8;
    }

    public Integer getDDCM_CMF_RELATION_8() {
        return DDCM_CMF_RELATION_8;
    }

    public void setDDCM_CMF_RELATION_8(Integer DDCM_CMF_RELATION_8) {
        this.DDCM_CMF_RELATION_8 = DDCM_CMF_RELATION_8;
    }

    public String getDDCM_CMF_AGE_8() {
        return DDCM_CMF_AGE_8;
    }

    public void setDDCM_CMF_AGE_8(String DDCM_CMF_AGE_8) {
        this.DDCM_CMF_AGE_8 = DDCM_CMF_AGE_8;
    }

    public Long getDDCM_CMF_INCOME_8() {
        return DDCM_CMF_INCOME_8;
    }

    public void setDDCM_CMF_INCOME_8(Long DDCM_CMF_INCOME_8) {
        this.DDCM_CMF_INCOME_8 = DDCM_CMF_INCOME_8;
    }

    public String getDDCM_CMF_SOURCE_8() {
        return DDCM_CMF_SOURCE_8;
    }

    public void setDDCM_CMF_SOURCE_8(String DDCM_CMF_SOURCE_8) {
        this.DDCM_CMF_SOURCE_8 = DDCM_CMF_SOURCE_8;
    }

    public Date getDDCM_DENY_RES_SSI() {
        return DDCM_DENY_RES_SSI;
    }

    public void setDDCM_DENY_RES_SSI(Date DDCM_DENY_RES_SSI) {
        this.DDCM_DENY_RES_SSI = DDCM_DENY_RES_SSI;
    }

    public Date getDDCM_DENY_RES_MEDICAID() {
        return DDCM_DENY_RES_MEDICAID;
    }

    public void setDDCM_DENY_RES_MEDICAID(Date DDCM_DENY_RES_MEDICAID) {
        this.DDCM_DENY_RES_MEDICAID = DDCM_DENY_RES_MEDICAID;
    }

    public Date getDDCM_DENY_RES_5WEEK() {
        return DDCM_DENY_RES_5WEEK;
    }

    public void setDDCM_DENY_RES_5WEEK(Date DDCM_DENY_RES_5WEEK) {
        this.DDCM_DENY_RES_5WEEK = DDCM_DENY_RES_5WEEK;
    }

    public Date getDDCM_DENY_DIS_SSI() {
        return DDCM_DENY_DIS_SSI;
    }

    public void setDDCM_DENY_DIS_SSI(Date DDCM_DENY_DIS_SSI) {
        this.DDCM_DENY_DIS_SSI = DDCM_DENY_DIS_SSI;
    }

    public Date getDDCM_DENY_DIS_MEDICAID() {
        return DDCM_DENY_DIS_MEDICAID;
    }

    public void setDDCM_DENY_DIS_MEDICAID(Date DDCM_DENY_DIS_MEDICAID) {
        this.DDCM_DENY_DIS_MEDICAID = DDCM_DENY_DIS_MEDICAID;
    }

    public Date getDDCM_SOBRA_DATE() {
        return DDCM_SOBRA_DATE;
    }

    public void setDDCM_SOBRA_DATE(Date DDCM_SOBRA_DATE) {
        this.DDCM_SOBRA_DATE = DDCM_SOBRA_DATE;
    }

    public Date getDDCM_NEEDY_DATE() {
        return DDCM_NEEDY_DATE;
    }

    public void setDDCM_NEEDY_DATE(Date DDCM_NEEDY_DATE) {
        this.DDCM_NEEDY_DATE = DDCM_NEEDY_DATE;
    }

    public Date getDDCM_MEDICAID_DATE() {
        return DDCM_MEDICAID_DATE;
    }

    public void setDDCM_MEDICAID_DATE(Date DDCM_MEDICAID_DATE) {
        this.DDCM_MEDICAID_DATE = DDCM_MEDICAID_DATE;
    }

    public Date getDDCM_SSI_DATE() {
        return DDCM_SSI_DATE;
    }

    public void setDDCM_SSI_DATE(Date DDCM_SSI_DATE) {
        this.DDCM_SSI_DATE = DDCM_SSI_DATE;
    }

    public Date getDDCM_PARENT_REFUSAL_DATE() {
        return DDCM_PARENT_REFUSAL_DATE;
    }

    public void setDDCM_PARENT_REFUSAL_DATE(Date DDCM_PARENT_REFUSAL_DATE) {
        this.DDCM_PARENT_REFUSAL_DATE = DDCM_PARENT_REFUSAL_DATE;
    }
}
