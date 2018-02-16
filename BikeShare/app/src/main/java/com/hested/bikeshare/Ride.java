package com.hested.bikeshare;

/**
 * Project:  BikeShare
 * Package:  com.hested.bikeshare
 * Date:     24-01-2018
 * Time:     23:34
 * Author:   Johnni Hested
 */
class Ride {
    private String mBikeName;
    private String mStartRide;

    public Ride(String name, String start) {
        mBikeName = name;
        mStartRide = start;
    }


    public String getBikeName() {
        return mBikeName;
    }

    public void setBikeName(String bikeName) {
        this.mBikeName = bikeName;
    }

    public String getStartRide() {
        return mStartRide;
    }

    public void setStartRide(String startRide) {
        this.mStartRide = startRide;
    }

    public String toString() {
        return mBikeName +" started here: " + mStartRide;
    }
}
