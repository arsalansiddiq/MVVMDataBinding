package com.raaziatariq.mvvmdatabinding.core.di.component;

import com.raaziatariq.mvvmdatabinding.core.base.EmomApplication;
import com.raaziatariq.mvvmdatabinding.core.di.builder.ActivityBuilder;
import com.raaziatariq.mvvmdatabinding.core.di.module.DatabaseModule;
import com.raaziatariq.mvvmdatabinding.core.di.module.EmomAppModule;
import com.raaziatariq.mvvmdatabinding.core.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        EmomAppModule.class,
        NetworkModule.class,
        DatabaseModule.class,
        ActivityBuilder.class})
public interface EmomComponent extends AndroidInjector<EmomApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<EmomApplication> {}

}
