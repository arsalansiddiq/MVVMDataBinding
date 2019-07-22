package com.raaziatariq.mvvmdatabinding.core.realm;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.raaziatariq.mvvmdatabinding.core.manager.SharedPreferencesConstants;
import com.raaziatariq.mvvmdatabinding.core.realm.table.DBModel;
import com.raaziatariq.mvvmdatabinding.core.realm.table.IDTable;
import com.raaziatariq.mvvmdatabinding.core.realm.table.PerimeterTable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmCRUD {

    @Inject
    Realm realm;

    @Inject
    public RealmCRUD() {
    }

    public void addID(DBModel dbModel) {
        realm.executeTransaction(realm -> {
            IDTable ids = realm.createObject(IDTable.class,dbModel.getId());
            ids.setNumbers(dbModel.getNumber());
            ids.setDevIds(dbModel.getDevId());
            realm.insertOrUpdate(ids);
        });
    }

    public int getID() {
        IDTable idTable = realm.where(IDTable.class).findAll().last(null);
        if (idTable != null) {
            return idTable.getIds();
        }
        else return 0;
    }

    public String getDevId() {
        IDTable idTable = realm.where(IDTable.class).findAll().last(null);
        if (idTable != null) {
            return idTable.getDevIds();
        }
        else return null;
    }


    public String getNumber(int id) {
        IDTable idTable = realm.where(IDTable.class).equalTo("ids", id).findFirst();
        if (idTable != null) {
            return idTable.getNumbers();
        }
        else return null;
    }



    public void insertOrUpdateTime (Date time, int id) {
        realm.executeTransaction(realm -> {
            IDTable idTable = realm.where(IDTable.class).equalTo("ids", id).findFirst();
            idTable.setTimeout(time);
            realm.insertOrUpdate(idTable);
        });
    }

    public String getTime (int id) {
        IDTable idTable = realm.where(IDTable.class).equalTo("ids", id).findFirst();
        if (idTable != null) {
            return String.valueOf(idTable.getTimeout());
        }
        else return null;
    }


    public boolean getCount () {
        int count = (int) realm.where(IDTable.class).count();
       Log.i("RealmCRUD",String.valueOf(count));
        return count != 0;
    }

    public boolean checkIDExist (int id) {
        IDTable object = realm.where(IDTable.class)
                .equalTo("ids", id)
                .findFirst();

        return object != null;

    }

    public void insertPerimeterPoints(List<LatLng> points, List<Float> zoom) {
        LatLng latLng;
        long check = 0;
        double lat, lang;
        for (int i = 0; i < points.size(); i++) {
            latLng = points.get(i);
            lat = latLng.latitude;
            lang = latLng.longitude;
            double finalLat = lat;
            double finalLang = lang;
            int finalI = i;
            realm.executeTransaction(realm -> {
                PerimeterTable perimeterTable = realm.createObject(PerimeterTable.class,1);
                perimeterTable.setLatitude(finalLat);
                perimeterTable.setLongitude(finalLang);
                perimeterTable.setCameraZoom(zoom.get(finalI));
                realm.insertOrUpdate(perimeterTable);
            });
            Log.i("RealmCRUD",String.valueOf(check));
        }
    }


    public List<LatLng> getPerimeterPoints() {

        List<LatLng> points = new ArrayList<>();

        RealmResults<PerimeterTable> perimeterTableRealmResults = realm.where(PerimeterTable.class).findAll();

        for(PerimeterTable perimeterTable: perimeterTableRealmResults){
            LatLng latLng = new LatLng(perimeterTable.getLatitude(),perimeterTable.getLongitude());
            Log.i("RealmCRUD",String.valueOf(latLng));
            points.add(latLng);
        }
        return points;
    }

    public float getAverageCameraPosition() {

        float allZoomPositions = 0;
        int count = 0;

        RealmResults<PerimeterTable> perimeterTableRealmResults = realm.where(PerimeterTable.class).findAll();

        for(PerimeterTable perimeterTable: perimeterTableRealmResults){
            allZoomPositions += perimeterTable.getCameraZoom();
            Log.i("RealmCRUD",String.valueOf(allZoomPositions));
            count++;
        }
        Log.i("RealmCRUD",String.valueOf(allZoomPositions));
        return (allZoomPositions / count);
    }
    //
    public boolean hasCoordinates(){
        RealmResults<PerimeterTable> perimeterTableRealmResults = realm.where(PerimeterTable.class).findAll();
        Log.i("RealmCRUD",String.valueOf(perimeterTableRealmResults.size()));
        return perimeterTableRealmResults.size() != 0;
    }

    public void isDeleted() {
        realm.executeTransaction(realm -> {
            realm.delete(PerimeterTable.class);
            RealmResults<PerimeterTable> perimeterTableRealmResults = realm.where(PerimeterTable.class).findAll();
            perimeterTableRealmResults.deleteAllFromRealm();
        });

    }

}

