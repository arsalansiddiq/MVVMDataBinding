package com.raaziatariq.mvvmdatabinding.ui.splashactivity;


import androidx.lifecycle.ViewModel;

import com.raaziatariq.mvvmdatabinding.core.manager.EmomSharedPreferences;
import com.raaziatariq.mvvmdatabinding.core.realm.RealmCRUD;
import com.raaziatariq.mvvmdatabinding.core.realm.table.DBModel;

import javax.inject.Inject;

public class SplashActivityViewModel extends ViewModel {
    EmomSharedPreferences emomSharedPreferences;
    RealmCRUD realmCRUD;


    @Inject
    public SplashActivityViewModel(EmomSharedPreferences emomSharedPreferences, RealmCRUD realmCRUD) {
        this.emomSharedPreferences = emomSharedPreferences;
        this.realmCRUD = realmCRUD;
    }

    String getDeviceId(){
        DBModel dbModel = new DBModel(1,"92442116599","fyfykvuk");
//        realmCRUD.addID(dbModel);
        return realmCRUD.getNumber(dbModel.getId());
    }
}
