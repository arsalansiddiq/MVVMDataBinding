package com.raaziatariq.mvvmdatabinding.core.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Inject;

public class EmomSharedPreferences {
    private SharedPreferences mSharedPreferences;

    @Inject
    public EmomSharedPreferences(Context context) {
        mSharedPreferences = context.getSharedPreferences(SharedPreferencesConstants.EMOM_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void putString(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    public void putInt(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    public void putBoolean(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public int getInt(String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    public String getString(String key) {
        return mSharedPreferences.getString(key, null);
    }

    public Boolean getBoolean(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }
}
