package com.raaziatariq.mvvmdatabinding.ui.pairing;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import com.raaziatariq.mvvmdatabinding.R;
import com.raaziatariq.mvvmdatabinding.core.base.BaseActivity;
import com.raaziatariq.mvvmdatabinding.core.network.model.request.caretakerrequest.CaretakerRequest;
import com.raaziatariq.mvvmdatabinding.core.network.model.response.CaretakerResponse;
import com.raaziatariq.mvvmdatabinding.core.network.retrofit.apiresponse.caretaker.APIResponseCaretaker;
import com.raaziatariq.mvvmdatabinding.databinding.ActivityPairingBinding;

import javax.inject.Inject;

public class PairingActivity extends BaseActivity<PairingActivityViewModel> {


    PairingActivityViewModel pairingActivityViewModel;

    @Inject
    ViewModelProvider.Factory factory;

    ActivityPairingBinding activityPairingBinding;

    @Override
    public PairingActivityViewModel getViewModel() {
        pairingActivityViewModel = ViewModelProviders.of(this, factory).get(PairingActivityViewModel.class);
        return pairingActivityViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPairingBinding = DataBindingUtil.setContentView(this,R.layout.activity_pairing);
        activityPairingBinding.setLifecycleOwner(this);
        activityPairingBinding.setPairingActivityViewModel(getViewModel());

        activityPairingBinding.btnConnect.setOnClickListener(view -> {
            CaretakerRequest caretakerRequest = new CaretakerRequest(activityPairingBinding.editTextNumber.getText().toString(),
                    "token kara do!", Settings.Secure.getString(getApplicationContext().getContentResolver(),
                    Settings.Secure.ANDROID_ID));
            pairingActivityViewModel.addCareTakerRequest(caretakerRequest);
            pairingActivityViewModel.addCaretaker().observe(this, this::consumeResponseCareTaker);
        });
    }

    private void consumeResponseCareTaker(APIResponseCaretaker apiResponseCaretaker) {

        switch (apiResponseCaretaker.status) {

            case LOADING:
                Toast.makeText(this, "loading...", Toast.LENGTH_SHORT).show();
                break;

            case SUCCESS:
                if (apiResponseCaretaker.data != null) {
                    renderSuccessResponse(apiResponseCaretaker.data);
                }
                break;

            case ERROR:
                Toast.makeText(this,"something went wrong", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    private void renderSuccessResponse(CaretakerResponse response) {
        Toast.makeText(this,response.getData().getCaretakerName(),Toast.LENGTH_LONG).show();
    }

}
