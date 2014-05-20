package net.therap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author jawad
 * @since 4/23/14  12:33 PM
 */
@Entity
@Table(name = "AR_CMS_ROOT")
public class TblDdsRoot {

    @Id
    @Column(name = "client_id")
    private int clientId;
    @Column(name = "client_ssn")
    private int clientSsn;
    @Column(name = "client_medicaid_no")
    private long clientMedicaidNo;
    @Column(name = "client_lastname")
    private String clientLastname;
    @Column(name = "client_firstname")
    private String clientFirstname;
    @Column(name = "client_middlename")
    private String clientMiddlename;
    @Column(name = "client_sex")
    private String clientSex;
    @Column(name = "client_race")
    private String clientRace;
    @Column(name = "client_primary")
    private String clientPrimary;
    @Column(name = "client_secondary")
    private String clientSecondary;
    @Column(name = "client_adapt")
    private String clientAdapt;
    @Column(name = "client_date_of_birth")
    private Date clientDateOfBirth;
    @Column(name = "client_date_of_application")
    private Date clientDateOfApplication;
    @Column(name = "client_date_of_diploma")
    private Date clientDateOfDiploma;
    @Column(name = "client_county")
    private String clientCounty;
    @Column(name = "client_language")
    private String clientLanguage;
    @Column(name = "client_house")
    private String clientHouse;
    @Column(name = "client_status")
    private String clientStatus;
    @Column(name = "client_medicaid_type")
    private String clientMedicaidType;
    @Column(name = "client_disability_1")
    private String clientDisability1;
    @Column(name = "client_disability_2")
    private String clientDisability2;
    @Column(name = "client_sub_disability_1")
    private String clientSubDisability1;
    @Column(name = "client_sub_disability_2")
    private String clientSubDisability2;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getClientSsn() {
        return clientSsn;
    }

    public void setClientSsn(int clientSsn) {
        this.clientSsn = clientSsn;
    }

    public long getClientMedicaidNo() {
        return clientMedicaidNo;
    }

    public void setClientMedicaidNo(long clientMedicaidNo) {
        this.clientMedicaidNo = clientMedicaidNo;
    }

    public String getClientLastname() {
        return clientLastname;
    }

    public void setClientLastname(String clientLastname) {
        this.clientLastname = clientLastname;
    }

    public String getClientFirstname() {
        return clientFirstname;
    }

    public void setClientFirstname(String clientFirstname) {
        this.clientFirstname = clientFirstname;
    }

    public String getClientMiddlename() {
        return clientMiddlename;
    }

    public void setClientMiddlename(String clientMiddlename) {
        this.clientMiddlename = clientMiddlename;
    }

    public String getClientSex() {
        return clientSex;
    }

    public void setClientSex(String clientSex) {
        this.clientSex = clientSex;
    }

    public String getClientRace() {
        return clientRace;
    }

    public void setClientRace(String clientRace) {
        this.clientRace = clientRace;
    }

    public String getClientPrimary() {
        return clientPrimary;
    }

    public void setClientPrimary(String clientPrimary) {
        this.clientPrimary = clientPrimary;
    }

    public String getClientSecondary() {
        return clientSecondary;
    }

    public void setClientSecondary(String clientSecondary) {
        this.clientSecondary = clientSecondary;
    }

    public String getClientAdapt() {
        return clientAdapt;
    }

    public void setClientAdapt(String clientAdapt) {
        this.clientAdapt = clientAdapt;
    }

    public Date getClientDateOfBirth() {
        return clientDateOfBirth;
    }

    public void setClientDateOfBirth(Date clientDateOfBirth) {
        this.clientDateOfBirth = clientDateOfBirth;
    }

    public Date getClientDateOfApplication() {
        return clientDateOfApplication;
    }

    public void setClientDateOfApplication(Date clientDateOfApplication) {
        this.clientDateOfApplication = clientDateOfApplication;
    }

    public Date getClientDateOfDiploma() {
        return clientDateOfDiploma;
    }

    public void setClientDateOfDiploma(Date clientDateOfDiploma) {
        this.clientDateOfDiploma = clientDateOfDiploma;
    }

    public String getClientCounty() {
        return clientCounty;
    }

    public void setClientCounty(String clientCounty) {
        this.clientCounty = clientCounty;
    }

    public String getClientLanguage() {
        return clientLanguage;
    }

    public void setClientLanguage(String clientLanguage) {
        this.clientLanguage = clientLanguage;
    }

    public String getClientHouse() {
        return clientHouse;
    }

    public void setClientHouse(String clientHouse) {
        this.clientHouse = clientHouse;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public String getClientMedicaidType() {
        return clientMedicaidType;
    }

    public void setClientMedicaidType(String clientMedicaidType) {
        this.clientMedicaidType = clientMedicaidType;
    }

    public String getClientDisability1() {
        return clientDisability1;
    }

    public void setClientDisability1(String clientDisability1) {
        this.clientDisability1 = clientDisability1;
    }

    public String getClientDisability2() {
        return clientDisability2;
    }

    public void setClientDisability2(String clientDisability2) {
        this.clientDisability2 = clientDisability2;
    }

    public String getClientSubDisability1() {
        return clientSubDisability1;
    }

    public void setClientSubDisability1(String clientSubDisability1) {
        this.clientSubDisability1 = clientSubDisability1;
    }

    public String getClientSubDisability2() {
        return clientSubDisability2;
    }

    public void setClientSubDisability2(String clientSubDisability2) {
        this.clientSubDisability2 = clientSubDisability2;
    }
}
