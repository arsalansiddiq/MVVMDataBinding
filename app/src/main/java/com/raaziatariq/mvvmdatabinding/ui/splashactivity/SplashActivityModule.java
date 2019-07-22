package com.raaziatariq.mvvmdatabinding.ui.splashactivity;



import androidx.lifecycle.ViewModelProvider;

import com.raaziatariq.mvvmdatabinding.core.manager.EmomSharedPreferences;
import com.raaziatariq.mvvmdatabinding.core.realm.RealmCRUD;
import com.raaziatariq.mvvmdatabinding.utils.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityModule {

    @Provides
    SplashActivityViewModel providesViewModel(EmomSharedPreferences emomSharedPreferences,RealmCRUD realmCRUD){
        return new SplashActivityViewModel(emomSharedPreferences,realmCRUD);
    }

    @Provides
    ViewModelProvider.Factory provideViewModelProvider(SplashActivityViewModel viewModel){
        return new ViewModelProviderFactory<>(viewModel);
    }
}