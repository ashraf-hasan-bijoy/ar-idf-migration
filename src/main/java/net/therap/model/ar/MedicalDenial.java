package net.therap.model.ar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author jawad
 * @since 5/19/14  10:18 AM
 */
@Entity
@Table(name = "AR_DDS_MED_DENIAL")
public class MedicalDenial {
    @Id
    @Column(name = "client_id")
    private int clientId;
    @Column(name = "medical_denial_start_date")
    private Date medicalDenialStartDate;
    @Column(name = "medical_denial_end_date")
    private Date medicalDenialEndDate;
    @Column(name = "medical_denial_option_delete")
    private String medicalDenialOptionDelete;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getMedicalDenialStartDate() {
        return medicalDenialStartDate;
    }

    public void setMedicalDenialStartDate(Date medicalDenialStartDate) {
        this.medicalDenialStartDate = medicalDenialStartDate;
    }

    public Date getMedicalDenialEndDate() {
        return medicalDenialEndDate;
    }

    public void setMedicalDenialEndDate(Date medicalDenialEndDate) {
        this.medicalDenialEndDate = medicalDenialEndDate;
    }

    public String getMedicalDenialOptionDelete() {
        return medicalDenialOptionDelete;
    }

    public void setMedicalDenialOptionDelete(String medicalDenialOptionDelete) {
        this.medicalDenialOptionDelete = medicalDenialOptionDelete;
    }
}
