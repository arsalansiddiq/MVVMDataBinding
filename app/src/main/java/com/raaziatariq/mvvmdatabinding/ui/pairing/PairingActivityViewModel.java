package com.raaziatariq.mvvmdatabinding.ui.pairing;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.raaziatariq.mvvmdatabinding.core.manager.EmomSharedPreferences;
import com.raaziatariq.mvvmdatabinding.core.network.retrofit.apiresponse.caretaker.APIResponseCaretaker;
import com.raaziatariq.mvvmdatabinding.ui.trackingactivity.TrackingActivityRepository;

import javax.inject.Inject;

public class PairingActivityViewModel  extends ViewModel {

    private PairingActivityRepository pairingActivityRepository;

    @Inject
    public PairingActivityViewModel(PairingActivityRepository pairingActivityRepository) {
        this.pairingActivityRepository = pairingActivityRepository;
    }

}
