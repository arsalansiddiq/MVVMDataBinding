
package com.raaziatariq.mvvmdatabinding.core.network.model.response;

import java.util.List;
import com.google.gson.annotations.Expose;


public class Data {

    @Expose
    private Long caretakerId;
    @Expose
    private String caretakerName;
    @Expose
    private String createddate;
    @Expose
    private List<DeviceDetail> deviceDetails;
    @Expose
    private String pairingStatus;
    @Expose
    private String token;

    public Long getCaretakerId() {
        return caretakerId;
    }

    public void setCaretakerId(Long caretakerId) {
        this.caretakerId = caretakerId;
    }

    public String getCaretakerName() {
        return caretakerName;
    }

    public void setCaretakerName(String caretakerName) {
        this.caretakerName = caretakerName;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public List<DeviceDetail> getDeviceDetails() {
        return deviceDetails;
    }

    public void setDeviceDetails(List<DeviceDetail> deviceDetails) {
        this.deviceDetails = deviceDetails;
    }

    public String getPairingStatus() {
        return pairingStatus;
    }

    public void setPairingStatus(String pairingStatus) {
        this.pairingStatus = pairingStatus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
