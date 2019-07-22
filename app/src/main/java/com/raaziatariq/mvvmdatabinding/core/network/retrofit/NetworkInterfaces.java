package com.raaziatariq.mvvmdatabinding.core.network.retrofit;

import com.raaziatariq.mvvmdatabinding.core.network.model.request.caretakerrequest.CaretakerRequest;
import com.raaziatariq.mvvmdatabinding.core.network.model.response.CaretakerResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NetworkInterfaces {

    @Headers("Content-Type: application/json")
    @POST("caretaker/addCaretaker")
    Observable<CaretakerResponse> registerCaretaker(@Body CaretakerRequest caretakerRequest);
}
