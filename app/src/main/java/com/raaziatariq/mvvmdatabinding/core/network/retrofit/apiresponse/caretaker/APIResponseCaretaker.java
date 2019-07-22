package com.raaziatariq.mvvmdatabinding.core.network.retrofit.apiresponse.caretaker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.raaziatariq.mvvmdatabinding.core.network.model.response.CaretakerResponse;
import com.raaziatariq.mvvmdatabinding.core.network.retrofit.apiresponse.Status;

public class APIResponseCaretaker {
    public Status status;

    @Nullable
    public CaretakerResponse data;

    @Nullable
    public Throwable error;

    private APIResponseCaretaker(Status status, @Nullable CaretakerResponse data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public APIResponseCaretaker() {
    }

    public static APIResponseCaretaker loading() {
        return new APIResponseCaretaker(Status.LOADING, null, null);
    }

    public static APIResponseCaretaker success(@NonNull CaretakerResponse data) {
        return new APIResponseCaretaker(Status.SUCCESS, data, null);
    }

    public static APIResponseCaretaker error(@NonNull Throwable error) {
        return new APIResponseCaretaker(Status.ERROR, null, error);
    }
}
