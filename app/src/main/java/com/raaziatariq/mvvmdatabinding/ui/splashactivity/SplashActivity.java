package com.raaziatariq.mvvmdatabinding.ui.splashactivity;


import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.raaziatariq.mvvmdatabinding.R;
import com.raaziatariq.mvvmdatabinding.core.base.BaseActivity;
import com.raaziatariq.mvvmdatabinding.databinding.ActivitySplashBinding;

import javax.inject.Inject;


public class SplashActivity extends BaseActivity<SplashActivityViewModel> {

    SplashActivityViewModel viewModel;
    @Inject
    ViewModelProvider.Factory factory;

    ActivitySplashBinding splashBinding;

    @Override
    public SplashActivityViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(SplashActivityViewModel.class);
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        splashBinding = DataBindingUtil.setContentView(this,R.layout.activity_splash);
        splashBinding.setLifecycleOwner(this);
        splashBinding.setSplashActivityViewModel(viewModel);

        Log.i("RealmCRUD","Device Number " + viewModel.getDeviceId());

    }
}
