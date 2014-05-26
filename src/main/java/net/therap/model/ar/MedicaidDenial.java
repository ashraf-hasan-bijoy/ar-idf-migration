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
public class MedicaidDenial {
    @Id
    @Column(name = "client_id")
    private int clientId;
    @Column(name = "medicaid_denial_start_date")
    private Date medicaidDenialStartDate;
    @Column(name = "medicaid_denial_end_date")
    private Date medicaidDenialEndDate;
    @Column(name = "medicaid_denial_option_delete")
    private String medicaidDenialOptionDelete;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getMedicaidDenialStartDate() {
        return medicaidDenialStartDate;
    }

    public void setMedicaidDenialStartDate(Date medicaidDenialStartDate) {
        this.medicaidDenialStartDate = medicaidDenialStartDate;
    }

    public Date getMedicaidDenialEndDate() {
        return medicaidDenialEndDate;
    }

    public void setMedicaidDenialEndDate(Date medicaidDenialEndDate) {
        this.medicaidDenialEndDate = medicaidDenialEndDate;
    }

    public String getMedicaidDenialOptionDelete() {
        return medicaidDenialOptionDelete;
    }

    public void setMedicaidDenialOptionDelete(String medicaidDenialOptionDelete) {
        this.medicaidDenialOptionDelete = medicaidDenialOptionDelete;
    }
}
