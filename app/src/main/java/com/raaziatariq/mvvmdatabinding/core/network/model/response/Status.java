
package com.raaziatariq.mvvmdatabinding.core.network.model.response;

import com.google.gson.annotations.Expose;

public class Status {

    @Expose
    private String message;
    @Expose
    private Long statusCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }

}
