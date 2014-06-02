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
    @Column(name = "field_client_id")
    private Long fieldClientId;
    @Column(name = "field_reason_closed")
    private String fieldReasonClosed;
    @Column(name = "field_caseload_status")
    private String fieldCaseloadStatus;
    @Column(name = "field_father_name")
    private String fieldFatherName;
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
    @Column(name = "field_father_phone_res_ac")
    private String fieldFatherPhoneResAc;
    @Column(name = "field_father_phone_res")
    private String fieldFatherPhoneRes;
    @Column(name = "field_father_phone_bus_ac")
    private String fieldFatherPhoneBusAc;
    @Column(name = "field_father_phone_bus")
    private String fieldFatherPhoneBus;
    @Column(name = "field_father_phone_mes_ac")
    private String fieldFatherPhoneMesAc;
    @Column(name = "field_father_phone_mes")
    private String fieldFatherPhoneMes;
    @Column(name = "field_mother_name")
    private String fieldMotherName;
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
    @Column(name = "field_mother_phone_res_ac")
    private String fieldMotherPhoneResAc;
    @Column(name = "field_mother_phone_res")
    private String fieldMotherPhoneRes;
    @Column(name = "field_mother_phone_bus_ac")
    private String fieldMotherPhoneBusAc;
    @Column(name = "field_mother_phone_bus")
    private String fieldMotherPhoneBus;
    @Column(name = "field_mother_phone_mes_ac")
    private String fieldMotherPhoneMesAc;
    @Column(name = "field_mother_phone_mes")
    private String fieldMotherPhoneMes;

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

    public String getFieldFatherName() {
        return fieldFatherName;
    }

    public void setFieldFatherName(String fieldFatherName) {
        this.fieldFatherName = fieldFatherName;
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

    public String getFieldMotherName() {
        return fieldMotherName;
    }

    public void setFieldMotherName(String fieldMotherName) {
        this.fieldMotherName = fieldMotherName;
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

    public String getFieldFatherPhoneResAc() {
        return fieldFatherPhoneResAc;
    }

    public void setFieldFatherPhoneResAc(String fieldFatherPhoneResAc) {
        this.fieldFatherPhoneResAc = fieldFatherPhoneResAc;
    }

    public String getFieldFatherPhoneRes() {
        return fieldFatherPhoneRes;
    }

    public void setFieldFatherPhoneRes(String fieldFatherPhoneRes) {
        this.fieldFatherPhoneRes = fieldFatherPhoneRes;
    }

    public String getFieldFatherPhoneBusAc() {
        return fieldFatherPhoneBusAc;
    }

    public void setFieldFatherPhoneBusAc(String fieldFatherPhoneBusAc) {
        this.fieldFatherPhoneBusAc = fieldFatherPhoneBusAc;
    }

    public String getFieldFatherPhoneBus() {
        return fieldFatherPhoneBus;
    }

    public void setFieldFatherPhoneBus(String fieldFatherPhoneBus) {
        this.fieldFatherPhoneBus = fieldFatherPhoneBus;
    }

    public String getFieldFatherPhoneMesAc() {
        return fieldFatherPhoneMesAc;
    }

    public void setFieldFatherPhoneMesAc(String fieldFatherPhoneMesAc) {
        this.fieldFatherPhoneMesAc = fieldFatherPhoneMesAc;
    }

    public String getFieldFatherPhoneMes() {
        return fieldFatherPhoneMes;
    }

    public void setFieldFatherPhoneMes(String fieldFatherPhoneMes) {
        this.fieldFatherPhoneMes = fieldFatherPhoneMes;
    }

    public String getFieldMotherPhoneResAc() {
        return fieldMotherPhoneResAc;
    }

    public void setFieldMotherPhoneResAc(String fieldMotherPhoneResAc) {
        this.fieldMotherPhoneResAc = fieldMotherPhoneResAc;
    }

    public String getFieldMotherPhoneRes() {
        return fieldMotherPhoneRes;
    }

    public void setFieldMotherPhoneRes(String fieldMotherPhoneRes) {
        this.fieldMotherPhoneRes = fieldMotherPhoneRes;
    }

    public String getFieldMotherPhoneBusAc() {
        return fieldMotherPhoneBusAc;
    }

    public void setFieldMotherPhoneBusAc(String fieldMotherPhoneBusAc) {
        this.fieldMotherPhoneBusAc = fieldMotherPhoneBusAc;
    }

    public String getFieldMotherPhoneBus() {
        return fieldMotherPhoneBus;
    }

    public void setFieldMotherPhoneBus(String fieldMotherPhoneBus) {
        this.fieldMotherPhoneBus = fieldMotherPhoneBus;
    }

    public String getFieldMotherPhoneMesAc() {
        return fieldMotherPhoneMesAc;
    }

    public void setFieldMotherPhoneMesAc(String fieldMotherPhoneMesAc) {
        this.fieldMotherPhoneMesAc = fieldMotherPhoneMesAc;
    }

    public String getFieldMotherPhoneMes() {
        return fieldMotherPhoneMes;
    }

    public void setFieldMotherPhoneMes(String fieldMotherPhoneMes) {
        this.fieldMotherPhoneMes = fieldMotherPhoneMes;
    }
}
