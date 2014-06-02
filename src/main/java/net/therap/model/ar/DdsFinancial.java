package net.therap.model.ar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jawad
 * @since 5/28/14  1:06 PM
 */
@Entity
@Table(name = "AR_DDS_FINANCIAL")
public class DdsFinancial {
    @Id
    @Column(name = "client_id")
    private long clientId;
    @Column(name = "guardian_type")
    private String guardianType;
    @Column(name = "guardian_name")
    private String guardianName;
    @Column(name = "guardian_address")
    private String guardianAddress;
    @Column(name = "guardian_city")
    private String guardianCity;
    @Column(name = "guardian_state")
    private String guardianState;
    @Column(name = "guardian_zip")
    private String guardianZip;
    @Column(name = "guardian_phone")
    private String guardianPhone;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getGuardianType() {
        return guardianType;
    }

    public void setGuardianType(String guardianType) {
        this.guardianType = guardianType;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianAddress() {
        return guardianAddress;
    }

    public void setGuardianAddress(String guardianAddress) {
        this.guardianAddress = guardianAddress;
    }

    public String getGuardianCity() {
        return guardianCity;
    }

    public void setGuardianCity(String guardianCity) {
        this.guardianCity = guardianCity;
    }

    public String getGuardianState() {
        return guardianState;
    }

    public void setGuardianState(String guardianState) {
        this.guardianState = guardianState;
    }

    public String getGuardianZip() {
        return guardianZip;
    }

    public void setGuardianZip(String guardianZip) {
        this.guardianZip = guardianZip;
    }

    public String getGuardianPhone() {
        return guardianPhone;
    }

    public void setGuardianPhone(String guardianPhone) {
        this.guardianPhone = guardianPhone;
    }
}
