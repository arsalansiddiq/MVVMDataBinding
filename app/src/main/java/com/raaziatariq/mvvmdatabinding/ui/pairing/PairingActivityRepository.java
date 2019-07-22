package com.raaziatariq.mvvmdatabinding.ui.pairing;

import androidx.lifecycle.MutableLiveData;

import com.raaziatariq.mvvmdatabinding.core.network.model.request.caretakerrequest.CaretakerRequest;
import com.raaziatariq.mvvmdatabinding.core.network.model.response.CaretakerResponse;
import com.raaziatariq.mvvmdatabinding.core.network.retrofit.NetworkInterfaces;
import com.raaziatariq.mvvmdatabinding.core.network.retrofit.apiresponse.caretaker.APIResponseCaretaker;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PairingActivityRepository {

    private NetworkInterfaces networkInterfaces;
    private CompositeDisposable disposables = new CompositeDisposable();
    private MutableLiveData<APIResponseCaretaker> responseLiveData = new MutableLiveData<>();


    @Inject
    public PairingActivityRepository(NetworkInterfaces networkInterfaces) {
        this.networkInterfaces = networkInterfaces;
    }

    public MutableLiveData<APIResponseCaretaker> getResponseLiveData() {
        return responseLiveData;
    }

    public void addCaretaker(CaretakerRequest caretakerRequest) {
        Observable<CaretakerResponse> responseObservable = networkInterfaces.registerCaretaker(caretakerRequest);
        disposables.add(responseObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((r) -> responseLiveData.setValue(APIResponseCaretaker.loading()))
                .subscribe(
                        result -> responseLiveData.setValue(APIResponseCaretaker.success(result)),
                        throwable -> responseLiveData.setValue(APIResponseCaretaker.error(throwable))
                ));
    }
}
