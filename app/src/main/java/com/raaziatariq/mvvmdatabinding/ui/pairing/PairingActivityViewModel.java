package com.raaziatariq.mvvmdatabinding.ui.pairing;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.raaziatariq.mvvmdatabinding.core.manager.EmomSharedPreferences;
import com.raaziatariq.mvvmdatabinding.core.network.model.request.caretakerrequest.CaretakerRequest;
import com.raaziatariq.mvvmdatabinding.core.network.retrofit.apiresponse.caretaker.APIResponseCaretaker;
import com.raaziatariq.mvvmdatabinding.ui.trackingactivity.TrackingActivityRepository;

import javax.inject.Inject;

public class PairingActivityViewModel  extends ViewModel {

    private MutableLiveData<APIResponseCaretaker> listLiveData;
    private PairingActivityRepository pairingActivityRepository;
    private CaretakerRequest caretakerRequest;

    @Inject
    public PairingActivityViewModel(PairingActivityRepository pairingActivityRepository) {
        this.pairingActivityRepository = pairingActivityRepository;
    }

    MutableLiveData<APIResponseCaretaker> addCaretaker(){
        pairingActivityRepository.addCaretaker(caretakerRequest);
        if(listLiveData == null)
            listLiveData = pairingActivityRepository.getResponseLiveData();
        return listLiveData;
    }

    public void addCareTakerRequest(CaretakerRequest caretakerRequest) {
        this.caretakerRequest = caretakerRequest;
    }
}
