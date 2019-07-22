package com.raaziatariq.mvvmdatabinding.ui.pairing;

import androidx.lifecycle.ViewModelProvider;

import com.raaziatariq.mvvmdatabinding.core.manager.EmomSharedPreferences;
import com.raaziatariq.mvvmdatabinding.core.network.retrofit.NetworkInterfaces;
import com.raaziatariq.mvvmdatabinding.ui.trackingactivity.TrackingActivityRepository;
import com.raaziatariq.mvvmdatabinding.ui.trackingactivity.TrackingActivityViewModel;
import com.raaziatariq.mvvmdatabinding.utils.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class PairingActivityModule {

    @Provides
    PairingActivityViewModel providesViewModel(PairingActivityRepository pairingActivityRepository){
        return new PairingActivityViewModel(pairingActivityRepository);
    }

    @Provides
    PairingActivityRepository provideRepository(NetworkInterfaces networkInterfaces){
        return new PairingActivityRepository(networkInterfaces);
    }

    @Provides
    ViewModelProvider.Factory provideViewModelProvider(TrackingActivityViewModel viewModel){
        return new ViewModelProviderFactory<>(viewModel);
    }

}
