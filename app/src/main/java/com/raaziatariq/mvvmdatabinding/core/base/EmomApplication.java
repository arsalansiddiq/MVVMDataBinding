package com.raaziatariq.mvvmdatabinding.core.base;

import com.raaziatariq.mvvmdatabinding.BuildConfig;
import com.raaziatariq.mvvmdatabinding.core.di.component.DaggerEmomComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class EmomApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerEmomComponent.builder().create(this);
    }
}
