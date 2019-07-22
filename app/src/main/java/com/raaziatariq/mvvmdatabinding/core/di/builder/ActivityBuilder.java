package com.raaziatariq.mvvmdatabinding.core.di.builder;

import com.raaziatariq.mvvmdatabinding.ui.pairing.PairingActivity;
import com.raaziatariq.mvvmdatabinding.ui.pairing.PairingActivityModule;
import com.raaziatariq.mvvmdatabinding.ui.splashactivity.SplashActivity;
import com.raaziatariq.mvvmdatabinding.ui.splashactivity.SplashActivityModule;
import com.raaziatariq.mvvmdatabinding.ui.trackingactivity.TrackingActivity;
import com.raaziatariq.mvvmdatabinding.ui.trackingactivity.TrackingActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder{

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity contributeSplashScreenActivity();

    @ContributesAndroidInjector(modules = PairingActivityModule.class)
    abstract PairingActivity contributePairingActivityModule();

    @ContributesAndroidInjector(modules = TrackingActivityModule.class)
    abstract TrackingActivity contributeTrackingActivityModule();
}
