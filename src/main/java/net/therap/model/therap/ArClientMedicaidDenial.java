package net.therap.model.therap;

import net.therap.db.archive.annotations.Archivable;
import net.therap.db.archive.annotations.ArchiveProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jahangir
 * @since 5/22/14 11:20 AM
 */
@Embeddable
@Archivable(nodeName = "arClientMedicaidDenial")
public class ArClientMedicaidDenial implements Serializable {

    @ArchiveProperty(embeddable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date medicaidDenialBeginDate;

    @ArchiveProperty(embeddable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date medicaidDenialEndDate;

    @Column(name = "medicaid_dnl_option_to_delete")
    private Boolean medicaidDenialOptionToDelete;

    public Date getMedicaidDenialBeginDate() {
        return medicaidDenialBeginDate;
    }

    public void setMedicaidDenialBeginDate(Date medicaidDenialBeginDate) {
        this.medicaidDenialBeginDate = medicaidDenialBeginDate;
    }

    public Date getMedicaidDenialEndDate() {
        return medicaidDenialEndDate;
    }

    public void setMedicaidDenialEndDate(Date medicaidDenialEndDate) {
        this.medicaidDenialEndDate = medicaidDenialEndDate;
    }

    public Boolean getMedicaidDenialOptionToDelete() {
        return medicaidDenialOptionToDelete;
    }

    public void setMedicaidDenialOptionToDelete(Boolean medicaidDenialOptionToDelete) {
        this.medicaidDenialOptionToDelete = medicaidDenialOptionToDelete;
    }
}
