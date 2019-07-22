package com.raaziatariq.mvvmdatabinding.ui.trackingactivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.raaziatariq.mvvmdatabinding.R;
import com.raaziatariq.mvvmdatabinding.core.base.BaseActivity;
import com.raaziatariq.mvvmdatabinding.core.network.model.response.CaretakerResponse;
import com.raaziatariq.mvvmdatabinding.core.network.retrofit.apiresponse.caretaker.APIResponseCaretaker;
import com.raaziatariq.mvvmdatabinding.databinding.ActivityTrackingBinding;

import javax.inject.Inject;

public class TrackingActivity extends BaseActivity<TrackingActivityViewModel> {

    TrackingActivityViewModel viewModel;

    @Inject
    ViewModelProvider.Factory factory;

    ActivityTrackingBinding trackingBinding;

    @Override
    public TrackingActivityViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(TrackingActivityViewModel.class);
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        trackingBinding = DataBindingUtil.setContentView(this,R.layout.activity_tracking);
        trackingBinding.setLifecycleOwner(this);
        trackingBinding.setTrackingActivityViewModel(viewModel);

        viewModel.getCareTaker().observe(this, this::consumeResponseCareTaker);
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
