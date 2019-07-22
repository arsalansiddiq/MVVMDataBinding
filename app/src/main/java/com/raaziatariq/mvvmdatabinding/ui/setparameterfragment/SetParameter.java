package com.raaziatariq.mvvmdatabinding.ui.setparameterfragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raaziatariq.mvvmdatabinding.R;
import com.raaziatariq.mvvmdatabinding.core.base.BaseFragment;
import com.raaziatariq.mvvmdatabinding.databinding.FragmentSetParameterBinding;

import javax.inject.Inject;


public class SetParameter extends BaseFragment<SetParameterViewModel> {


    private SetParameterViewModel setParameterViewModel;
    FragmentSetParameterBinding fragmentSetParameterBinding;

    @Inject
    ViewModelProvider.Factory factory;

    public SetParameter() {
        // Required empty public constructor
    }

    @Override
    public SetParameterViewModel getViewModel() {
        return ViewModelProviders.of(this,factory).get(SetParameterViewModel.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSetParameterBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_set_parameter,container,false);
        fragmentSetParameterBinding.setLifecycleOwner(this);
        return fragmentSetParameterBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
