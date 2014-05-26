package net.therap.model.therap;

import net.therap.db.archive.ArchiveConstants;
import net.therap.db.archive.annotations.*;
import net.therap.db.entity.common.Client;
import net.therap.db.entity.common.Login;
import net.therap.db.entity.common.Persistent;
import net.therap.db.entity.common.Provider;
import net.therap.db.util.CommonForm;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author jahangir
 * @since 5/4/14 11:30 AM
 */
@Entity
@Table(name = "ar_client")
@NamedQueries({
        @NamedQuery(name = "ArClient.findByClient", query = "SELECT arc FROM ArClient arc WHERE arc.client = :client"),
        @NamedQuery(name = "ArClient.findByFormId", query = "SELECT arc FROM ArClient arc WHERE arc.formId = :formId")
})
//@Archivable(nodeName = CommonForm.FT_AR_IDF_EXT, formType = CommonForm.FT_AR_IDF_EXT,
//        viewTech = ArchiveConstants.VIEW_TECH_XSL, archiveVersion = "2014.1.1")
public class ArClient extends Persistent {

    private static final long serialVersionUID = 1L;

    public static final String ARCHIVE_VERSION = "2014.1.1";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "arClientSeq")
    @SequenceGenerator(name = "arClientSeq", sequenceName = "ar_client_seq", allocationSize = 1)
    private long id;

    @Column(unique = true, nullable = false, updatable = false, length = 32)
    @ArchiveFormId
    private String formId;

    @OneToOne(optional = false)
    @ArchiveClient
    private Client client;

    @ManyToOne(optional = false)
    @JoinColumn(name = "prov_id")
    @ArchiveProvider
    private Provider provider;

    @Column(length = 1)
    @Size(max = 1)
    private String ddsCaseloadStatus;

    @Column(length = 1)
    @Size(max = 1)
    private String ddsCaseloadCloseReason;

    @Column(length = 8)
    @Size(max = 8)
    private String countyCode;

    @Temporal(TemporalType.TIMESTAMP)
    private Date diplomaDate;

    @Column(length = 2)
    private String primaryDisability;

    @Column(length = 2)
    private String secondaryDisability;

    @Column(length = 1)
    @Size(max = 1)
    private String adaptiveBehaviorIndicator;

    @Column(length = 2)
    @Size(max = 2)
    private String primaryHomeLanguage;

    @Column(length = 2)
    @Size(max = 2)
    private String numberInHousehold;

    @Column(columnDefinition = "NUMBER (10, 2)")
    private Double monthlyMedicalBill;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ssnDenialLetterDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date medicaidDenialLetterDate;

    private Boolean receivingSobra;

    private Boolean receivingMedicaid;

    private Boolean receivingSsi;

    private Boolean medicallyNeedy;

    private Boolean medicaidTypeArkids;

    @Temporal(TemporalType.TIMESTAMP)
    private Date resources5WeekSpinDown;

    @Temporal(TemporalType.TIMESTAMP)
    private Date disabilitySsi;

    @Column(name = "disability_medicaid_denl_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date disabilityMedicaidDenialDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sobraAppliedDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date needyDeterminationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date medicaidDeterminationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ssiDeterminationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date parentsRefusalDate;

    @Column
    private Long ddsId;

    @Column
    private Long cmsId;

    @Column(length = 1)
    @Size(max = 1)
    private String cmsStatusCode;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cmsApplyDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cmsReapplyDate;

    @Column(length = 2)
    @Size(max = 2)
    private String cmsCommOfficeAreaCode;

    @Column(length = 1)
    @Size(max = 1)
    private String cmsMedicaidStatus;

    @Column(length = 2)
    @Size(max = 2)
    private String cmsMedicaidCategory;

    private Long cmsMedicaidProviderNo;

    @Column(length = 32)
    @Size(max = 32)
    private String cmsPrimaryPhysician;

    @Column(length = 1)
    @Size(max = 1)
    private String thirdPartyLiability;

    @ManyToOne
    private Login createdBy;

    @ManyToOne
    private Login updatedBy;

    @ElementCollection
    @CollectionTable(name = "ar_eligibility_duration")
    @OrderColumn(name = "idx")
    @ArchiveProperty(embeddable = true)
    private List<ArEligibilityDuration> eligibilityDurations;

    @ElementCollection
    @CollectionTable(name = "ar_client_family_member")
    @OrderColumn(name = "idx")
    @ArchiveProperty(embeddable = true)
    private List<ArClientFamilyMember> familyMembers;

    @ElementCollection
    @CollectionTable(name = "ar_client_medical_denial")
    @OrderColumn(name = "idx")
    @ArchiveProperty(embeddable = true)
    private List<ArClientMedicaidDenial> medicaidDenials;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getDdsCaseloadStatus() {
        return ddsCaseloadStatus;
    }

    public void setDdsCaseloadStatus(String ddsCaseloadStatus) {
        this.ddsCaseloadStatus = ddsCaseloadStatus;
    }

    public String getDdsCaseloadCloseReason() {
        return ddsCaseloadCloseReason;
    }

    public void setDdsCaseloadCloseReason(String ddsCaseloadCloseReason) {
        this.ddsCaseloadCloseReason = ddsCaseloadCloseReason;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public Date getDiplomaDate() {
        return diplomaDate;
    }

    public void setDiplomaDate(Date diplomaDate) {
        this.diplomaDate = diplomaDate;
    }

    public String getPrimaryDisability() {
        return primaryDisability;
    }

    public void setPrimaryDisability(String primaryDisability) {
        this.primaryDisability = primaryDisability;
    }

    public String getSecondaryDisability() {
        return secondaryDisability;
    }

    public void setSecondaryDisability(String secondaryDisability) {
        this.secondaryDisability = secondaryDisability;
    }

    public String getAdaptiveBehaviorIndicator() {
        return adaptiveBehaviorIndicator;
    }

    public void setAdaptiveBehaviorIndicator(String adaptiveBehaviorIndicator) {
        this.adaptiveBehaviorIndicator = adaptiveBehaviorIndicator;
    }

    public String getPrimaryHomeLanguage() {
        return primaryHomeLanguage;
    }

    public void setPrimaryHomeLanguage(String primaryHomeLanguage) {
        this.primaryHomeLanguage = primaryHomeLanguage;
    }

    public String getNumberInHousehold() {
        return numberInHousehold;
    }

    public void setNumberInHousehold(String numberInHousehold) {
        this.numberInHousehold = numberInHousehold;
    }

    public Double getMonthlyMedicalBill() {
        return monthlyMedicalBill;
    }

    public void setMonthlyMedicalBill(Double monthlyMedicalBill) {
        this.monthlyMedicalBill = monthlyMedicalBill;
    }

    public Date getSsnDenialLetterDate() {
        return ssnDenialLetterDate;
    }

    public void setSsnDenialLetterDate(Date ssnDenialLetterDate) {
        this.ssnDenialLetterDate = ssnDenialLetterDate;
    }

    public Date getMedicaidDenialLetterDate() {
        return medicaidDenialLetterDate;
    }

    public void setMedicaidDenialLetterDate(Date medicaidDenialLetterDate) {
        this.medicaidDenialLetterDate = medicaidDenialLetterDate;
    }

    public Boolean getReceivingSobra() {
        return receivingSobra;
    }

    public void setReceivingSobra(Boolean receivingSobra) {
        this.receivingSobra = receivingSobra;
    }

    public Boolean getReceivingMedicaid() {
        return receivingMedicaid;
    }

    public void setReceivingMedicaid(Boolean receivingMedicaid) {
        this.receivingMedicaid = receivingMedicaid;
    }

    public Boolean getReceivingSsi() {
        return receivingSsi;
    }

    public void setReceivingSsi(Boolean receivingSsi) {
        this.receivingSsi = receivingSsi;
    }

    public Boolean getMedicallyNeedy() {
        return medicallyNeedy;
    }

    public void setMedicallyNeedy(Boolean medicallyNeedy) {
        this.medicallyNeedy = medicallyNeedy;
    }

    public Boolean getMedicaidTypeArkids() {
        return medicaidTypeArkids;
    }

    public void setMedicaidTypeArkids(Boolean medicaidTypeArkids) {
        this.medicaidTypeArkids = medicaidTypeArkids;
    }

    public Date getResources5WeekSpinDown() {
        return resources5WeekSpinDown;
    }

    public void setResources5WeekSpinDown(Date resources5WeekSpinDown) {
        this.resources5WeekSpinDown = resources5WeekSpinDown;
    }

    public Date getDisabilitySsi() {
        return disabilitySsi;
    }

    public void setDisabilitySsi(Date disabilitySsi) {
        this.disabilitySsi = disabilitySsi;
    }

    public Date getDisabilityMedicaidDenialDate() {
        return disabilityMedicaidDenialDate;
    }

    public void setDisabilityMedicaidDenialDate(Date disabilityMedicaidDenialDate) {
        this.disabilityMedicaidDenialDate = disabilityMedicaidDenialDate;
    }

    public Date getSobraAppliedDate() {
        return sobraAppliedDate;
    }

    public void setSobraAppliedDate(Date sobraAppliedDate) {
        this.sobraAppliedDate = sobraAppliedDate;
    }

    public Date getNeedyDeterminationDate() {
        return needyDeterminationDate;
    }

    public void setNeedyDeterminationDate(Date needyDeterminationDate) {
        this.needyDeterminationDate = needyDeterminationDate;
    }

    public Date getMedicaidDeterminationDate() {
        return medicaidDeterminationDate;
    }

    public void setMedicaidDeterminationDate(Date medicaidDeterminationDate) {
        this.medicaidDeterminationDate = medicaidDeterminationDate;
    }

    public Date getSsiDeterminationDate() {
        return ssiDeterminationDate;
    }

    public void setSsiDeterminationDate(Date ssiDeterminationDate) {
        this.ssiDeterminationDate = ssiDeterminationDate;
    }

    public Date getParentsRefusalDate() {
        return parentsRefusalDate;
    }

    public void setParentsRefusalDate(Date parentsRefusalDate) {
        this.parentsRefusalDate = parentsRefusalDate;
    }

    public Long getDdsId() {
        return ddsId;
    }

    public void setDdsId(Long ddsId) {
        this.ddsId = ddsId;
    }

    public Long getCmsId() {
        return cmsId;
    }

    public void setCmsId(Long cmsId) {
        this.cmsId = cmsId;
    }

    public String getCmsStatusCode() {
        return cmsStatusCode;
    }

    public void setCmsStatusCode(String cmsStatusCode) {
        this.cmsStatusCode = cmsStatusCode;
    }

    public Date getCmsApplyDate() {
        return cmsApplyDate;
    }

    public void setCmsApplyDate(Date cmsApplyDate) {
        this.cmsApplyDate = cmsApplyDate;
    }

    public Date getCmsReapplyDate() {
        return cmsReapplyDate;
    }

    public void setCmsReapplyDate(Date cmsReapplyDate) {
        this.cmsReapplyDate = cmsReapplyDate;
    }

    public String getCmsCommOfficeAreaCode() {
        return cmsCommOfficeAreaCode;
    }

    public void setCmsCommOfficeAreaCode(String cmsCommOfficeAreaCode) {
        this.cmsCommOfficeAreaCode = cmsCommOfficeAreaCode;
    }

    public String getCmsMedicaidStatus() {
        return cmsMedicaidStatus;
    }

    public void setCmsMedicaidStatus(String cmsMedicaidStatus) {
        this.cmsMedicaidStatus = cmsMedicaidStatus;
    }

    public String getCmsMedicaidCategory() {
        return cmsMedicaidCategory;
    }

    public void setCmsMedicaidCategory(String cmsMedicaidCategory) {
        this.cmsMedicaidCategory = cmsMedicaidCategory;
    }

    public Long getCmsMedicaidProviderNo() {
        return cmsMedicaidProviderNo;
    }

    public void setCmsMedicaidProviderNo(Long cmsMedicaidProviderNo) {
        this.cmsMedicaidProviderNo = cmsMedicaidProviderNo;
    }

    public String getCmsPrimaryPhysician() {
        return cmsPrimaryPhysician;
    }

    public void setCmsPrimaryPhysician(String cmsPrimaryPhysician) {
        this.cmsPrimaryPhysician = cmsPrimaryPhysician;
    }

    public String getThirdPartyLiability() {
        return thirdPartyLiability;
    }

    public void setThirdPartyLiability(String thirdPartyLiability) {
        this.thirdPartyLiability = thirdPartyLiability;
    }

    public Login getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Login createdBy) {
        this.createdBy = createdBy;
    }

    public Login getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Login updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<ArEligibilityDuration> getEligibilityDurations() {
        return eligibilityDurations;
    }

    public void setEligibilityDurations(List<ArEligibilityDuration> eligibilityDurations) {
        this.eligibilityDurations = eligibilityDurations;
    }

    public List<ArClientFamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<ArClientFamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public List<ArClientMedicaidDenial> getMedicaidDenials() {
        return medicaidDenials;
    }

    public void setMedicaidDenials(List<ArClientMedicaidDenial> medicaidDenials) {
        this.medicaidDenials = medicaidDenials;
    }
}
