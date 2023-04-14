package com.bleiny.commons.domain.valueobjects;

public class GeolocalizationUser {
    private String lat;

    private String lon;

    private String maxDistance;

    private Boolean isGlobal;

    public GeolocalizationUser(String lat, String lon, String maxDistance, Boolean isGlobal) {
        this.lat = lat;
        this.lon = lon;
        this.maxDistance = maxDistance;
        this.isGlobal = isGlobal;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(String maxDistance) {
        this.maxDistance = maxDistance;
    }

    public Boolean getGlobal() {
        return isGlobal;
    }

    public void setGlobal(Boolean global) {
        isGlobal = global;
    }
}
