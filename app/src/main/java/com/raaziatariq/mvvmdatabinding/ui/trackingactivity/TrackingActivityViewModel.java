package com.raaziatariq.mvvmdatabinding.ui.trackingactivity;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.raaziatariq.mvvmdatabinding.core.manager.EmomSharedPreferences;
import com.raaziatariq.mvvmdatabinding.core.network.retrofit.apiresponse.caretaker.APIResponseCaretaker;

import javax.inject.Inject;

public class TrackingActivityViewModel extends ViewModel {
    EmomSharedPreferences emomSharedPreferences;
    TrackingActivityRepository trackingActivityRepository;
    private MutableLiveData<APIResponseCaretaker> listLiveData;

    @Inject
    public TrackingActivityViewModel(TrackingActivityRepository trackingActivityRepository, EmomSharedPreferences emomSharedPreferences) {
        this.trackingActivityRepository = trackingActivityRepository;
        this.emomSharedPreferences = emomSharedPreferences;
    }

    MutableLiveData<APIResponseCaretaker> getCareTaker(){
        trackingActivityRepository.getCareTaker();
        if(listLiveData == null)
            listLiveData = trackingActivityRepository.getResponseLiveData();
        return listLiveData;
    }

}
