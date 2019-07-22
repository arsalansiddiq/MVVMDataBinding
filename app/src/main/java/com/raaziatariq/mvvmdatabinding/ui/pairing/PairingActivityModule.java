package com.raaziatariq.mvvmdatabinding.ui.pairing;

import androidx.lifecycle.ViewModelProvider;

import com.raaziatariq.mvvmdatabinding.core.network.retrofit.NetworkInterfaces;
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
    ViewModelProvider.Factory provideViewModelProvider(PairingActivityViewModel viewModel){
        return new ViewModelProviderFactory<>(viewModel);
    }

}
