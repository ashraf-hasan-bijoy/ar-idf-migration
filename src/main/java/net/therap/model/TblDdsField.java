package net.therap.model;

/**
 * @author jawad
 * @since 4/23/14  12:33 PM
 */
public class TblDdsField {
    private int fieldClientId;
    private String fieldReasonClosed;
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
