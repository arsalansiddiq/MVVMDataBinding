
package com.raaziatariq.mvvmdatabinding.core.network.model.request.caretakerrequest;

import com.google.gson.annotations.Expose;

public class CaretakerRequest {

    @Expose
    private String deviceNumber;
    @Expose
    private String token;
    @Expose
    private String uId;

    public CaretakerRequest(String deviceNumber, String token, String uId) {
        this.deviceNumber = deviceNumber;
        this.token = token;
        this.uId = uId;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUId() {
        return uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

}
