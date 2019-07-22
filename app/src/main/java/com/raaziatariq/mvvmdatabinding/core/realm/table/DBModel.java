package com.raaziatariq.mvvmdatabinding.core.realm.table;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by arsalansiddiq on 2/19/18.
 */

public class DBModel {

    private int id;
    private String number;
    private String devId;
    private List<LatLng> points;
    private List<Float> zoom;

    public DBModel(List<LatLng> points, List<Float> zoom) {
        this.points = points;
        this.zoom = zoom;
    }

    public DBModel(int id) {
        this.id = id;
    }

    public String getDevId() {
        return devId;
    }

    public DBModel(int id, String number, String devId) {
        this.id = id;
        this.number = number;
        this.devId = devId;

    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public List<LatLng> getPoints() {
        return points;
    }

    public List<Float> getZoom() {
        return zoom;
    }
}
