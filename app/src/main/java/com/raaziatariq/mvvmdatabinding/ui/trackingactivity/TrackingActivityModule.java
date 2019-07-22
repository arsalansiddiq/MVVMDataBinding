package com.raaziatariq.mvvmdatabinding.ui.trackingactivity;



import androidx.lifecycle.ViewModelProvider;

import com.raaziatariq.mvvmdatabinding.core.manager.EmomSharedPreferences;
import com.raaziatariq.mvvmdatabinding.core.network.retrofit.NetworkInterfaces;
import com.raaziatariq.mvvmdatabinding.ui.splashactivity.SplashActivityViewModel;
import com.raaziatariq.mvvmdatabinding.utils.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class TrackingActivityModule {

    @Provides
    TrackingActivityViewModel providesViewModel(TrackingActivityRepository trackingActivityRepository,EmomSharedPreferences emomSharedPreferences){
        return new TrackingActivityViewModel(trackingActivityRepository,emomSharedPreferences);
    }

    @Provides
    TrackingActivityRepository provideRepository(NetworkInterfaces networkInterfaces){
        return new TrackingActivityRepository(networkInterfaces);
    }

    @Provides
    ViewModelProvider.Factory provideViewModelProvider(TrackingActivityViewModel viewModel){
        return new ViewModelProviderFactory<>(viewModel);
    }
}
