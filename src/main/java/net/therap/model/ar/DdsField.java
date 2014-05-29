package net.therap.model.ar;

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
public class DdsField {
    @Id
    @Column(name = "client_id")
    private Long fieldClientId;
    @Column(name = "field_reason_closed")
    private String fieldReasonClosed;
    @Column(name = "field_caseload_status")
    private String fieldCaseloadStatus;
    @Column(name = "field_father_address")
    private String fieldFatherAddress;
    @Column(name = "field_father_city")
    private String fieldFatherCity;
    @Column(name = "field_father_county")
    private String fieldFatherCounty;
    @Column(name = "field_father_state")
    private String fieldFatherState;
    @Column(name = "field_father_zip")
    private String fieldFatherZip;
    @Column(name = "field_mother_address")
    private String fieldMotherAddress;
    @Column(name = "field_mother_city")
    private String fieldMotherCity;
    @Column(name = "field_mother_county")
    private String fieldMotherCounty;
    @Column(name = "field_mother_state")
    private String fieldMotherState;
    @Column(name = "field_mother_zip")
    private String fieldMotherZip;

    public Long getFieldClientId() {
        return fieldClientId;
    }

    public void setFieldClientId(Long fieldClientId) {
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

    public String getFieldFatherAddress() {
        return fieldFatherAddress;
    }

    public void setFieldFatherAddress(String fieldFatherAddress) {
        this.fieldFatherAddress = fieldFatherAddress;
    }

    public String getFieldFatherCity() {
        return fieldFatherCity;
    }

    public void setFieldFatherCity(String fieldFatherCity) {
        this.fieldFatherCity = fieldFatherCity;
    }

    public String getFieldFatherCounty() {
        return fieldFatherCounty;
    }

    public void setFieldFatherCounty(String fieldFatherCounty) {
        this.fieldFatherCounty = fieldFatherCounty;
    }

    public String getFieldFatherState() {
        return fieldFatherState;
    }

    public void setFieldFatherState(String fieldFatherState) {
        this.fieldFatherState = fieldFatherState;
    }

    public String getFieldFatherZip() {
        return fieldFatherZip;
    }

    public void setFieldFatherZip(String fieldFatherZip) {
        this.fieldFatherZip = fieldFatherZip;
    }

    public String getFieldMotherAddress() {
        return fieldMotherAddress;
    }

    public void setFieldMotherAddress(String fieldMotherAddress) {
        this.fieldMotherAddress = fieldMotherAddress;
    }

    public String getFieldMotherCity() {
        return fieldMotherCity;
    }

    public void setFieldMotherCity(String fieldMotherCity) {
        this.fieldMotherCity = fieldMotherCity;
    }

    public String getFieldMotherCounty() {
        return fieldMotherCounty;
    }

    public void setFieldMotherCounty(String fieldMotherCounty) {
        this.fieldMotherCounty = fieldMotherCounty;
    }

    public String getFieldMotherState() {
        return fieldMotherState;
    }

    public void setFieldMotherState(String fieldMotherState) {
        this.fieldMotherState = fieldMotherState;
    }

    public String getFieldMotherZip() {
        return fieldMotherZip;
    }

    public void setFieldMotherZip(String fieldMotherZip) {
        this.fieldMotherZip = fieldMotherZip;
    }
}
