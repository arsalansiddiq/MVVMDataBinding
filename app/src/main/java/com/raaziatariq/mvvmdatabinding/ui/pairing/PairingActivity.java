package com.raaziatariq.mvvmdatabinding.ui.pairing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.raaziatariq.mvvmdatabinding.R;
import com.raaziatariq.mvvmdatabinding.core.base.BaseActivity;
import com.raaziatariq.mvvmdatabinding.databinding.ActivityPairingBinding;

import javax.inject.Inject;

public class PairingActivity extends BaseActivity<PairingActivityViewModel> {


    @Inject
    ViewModelProvider.Factory factory;

    ActivityPairingBinding activityPairingBinding;

    @Override
    public PairingActivityViewModel getViewModel() {
        return ViewModelProviders.of(this, factory).get(PairingActivityViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPairingBinding = DataBindingUtil.setContentView(this,R.layout.activity_pairing);
        activityPairingBinding.setLifecycleOwner(this);
        activityPairingBinding.setPairingActivityViewModel(getViewModel());

    }
}
