package com.raaziatariq.mvvmdatabinding.ui.pairing;

import androidx.lifecycle.MutableLiveData;

import com.raaziatariq.mvvmdatabinding.core.network.retrofit.NetworkInterfaces;
import com.raaziatariq.mvvmdatabinding.core.network.retrofit.apiresponse.caretaker.APIResponseCaretaker;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class PairingActivityRepository {

    private NetworkInterfaces networkInterfaces;
    private CompositeDisposable disposables = new CompositeDisposable();
    private MutableLiveData<APIResponseCaretaker> responseLiveData = new MutableLiveData<>();


    @Inject
    public PairingActivityRepository(NetworkInterfaces networkInterfaces) {
        this.networkInterfaces = networkInterfaces;
    }
}
