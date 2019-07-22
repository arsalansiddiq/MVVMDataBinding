package com.raaziatariq.mvvmdatabinding.core.di.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.raaziatariq.mvvmdatabinding.core.network.retrofit.NetworkInterfaces;
import com.raaziatariq.mvvmdatabinding.utils.Constants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private static int REQUEST_TIMEOUT = 10;
    private static OkHttpClient okHttpClient;

    @Singleton
    @Provides
    final OkHttpClient providesClient(){
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .build();

        return okHttpClient;
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(providesClient())
                .build();
        return retrofit;
    }

    @Singleton
    @Provides
    NetworkInterfaces provideApiService(Retrofit retrofit){
        return retrofit.create(NetworkInterfaces.class);
    }
}

