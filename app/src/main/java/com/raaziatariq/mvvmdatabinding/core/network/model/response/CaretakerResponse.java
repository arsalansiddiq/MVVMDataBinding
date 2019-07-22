
package com.raaziatariq.mvvmdatabinding.core.network.model.response;

import com.google.gson.annotations.Expose;


public class CaretakerResponse {

    @Expose
    private Data data;
    @Expose
    private Status status;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
