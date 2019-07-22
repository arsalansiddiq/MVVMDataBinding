package com.raaziatariq.mvvmdatabinding.core.realm.table;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class PerimeterTable extends RealmObject {
    @PrimaryKey
    private int perimeterIds;
    private double latitude;
    private double longitude;
    private float cameraZoom;

    public int getPerimeterIds() {
        return perimeterIds;
    }

    public void setPerimeterIds(int perimeterIds) {
        this.perimeterIds = perimeterIds;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public float getCameraZoom() {
        return cameraZoom;
    }

    public void setCameraZoom(float cameraZoom) {
        this.cameraZoom = cameraZoom;
    }
}
