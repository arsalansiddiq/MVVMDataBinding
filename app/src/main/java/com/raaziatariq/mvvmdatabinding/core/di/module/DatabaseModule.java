package com.raaziatariq.mvvmdatabinding.core.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@Module
public class DatabaseModule {

    @Provides
    Realm provideRealm(Context context) {
        Realm.init(context);
        RealmConfiguration.Builder builder = new RealmConfiguration.Builder();
        builder.name("emom.realm");

        RealmConfiguration config = builder.build();
        return Realm.getInstance(config);
    }
}
