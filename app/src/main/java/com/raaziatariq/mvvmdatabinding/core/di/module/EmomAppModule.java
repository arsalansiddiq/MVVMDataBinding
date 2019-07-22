package com.raaziatariq.mvvmdatabinding.core.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.raaziatariq.mvvmdatabinding.core.base.EmomApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class EmomAppModule {

    @Singleton
    @Provides
    Context provideContext(EmomApplication application){
        return application;
    }

    @Singleton
    @Provides
    Gson provideGson(){
        return new Gson();
    }

}

