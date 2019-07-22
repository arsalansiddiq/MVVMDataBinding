
package com.raaziatariq.mvvmdatabinding.core.network.model.response;

import com.google.gson.annotations.Expose;

public class DeviceDetail {

    @Expose
    private Long createdDate;
    @Expose
    private Long deviceId;
    @Expose
    private String deviceNumber;

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

}
