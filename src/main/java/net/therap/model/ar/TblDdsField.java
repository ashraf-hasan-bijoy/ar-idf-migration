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
@Table(name = "AR_DDS_FIELD")
public class TblDdsField {
    @Id
    @Column(name = "client_id")
    private int fieldClientId;
    @Column(name = "field_reason_closed")
    private String fieldReasonClosed;
    @Column(name = "field_caseload_status")
    private String fieldCaseloadStatus;

    public int getFieldClientId() {
        return fieldClientId;
    }

    public void setFieldClientId(int fieldClientId) {
        this.fieldClientId = fieldClientId;
    }

    public String getFieldReasonClosed() {
        return fieldReasonClosed;
    }

    public void setFieldReasonClosed(String fieldReasonClosed) {
        this.fieldReasonClosed = fieldReasonClosed;
    }

    public String getFieldCaseloadStatus() {
        return fieldCaseloadStatus;
    }

    public void setFieldCaseloadStatus(String fieldCaseloadStatus) {
        this.fieldCaseloadStatus = fieldCaseloadStatus;
    }
}
