package com.hested.bikeshare;

import java.util.ArrayList;
import java.util.List;

/**
 * Project:  BikeShare
 * Package:  com.hested.bikeshare
 * Date:     15-02-2018
 * Time:     14:39
 * Author:   Johnni Hested
 */
class RidesDB {
    private static final RidesDB ourInstance = new RidesDB();

    private List<Ride> mRides;
    private Ride mLastRide= new Ride("", "");

    static RidesDB getInstance() {
        return ourInstance;
    }

    private RidesDB() {

        if (mRides == null) {
            mRides = new ArrayList<>();

            for (int i = 1; i <= 40; i++) {
                mRides.add(new Ride("Peters bike" + i, "ITU" + i));
                mRides.add(new Ride("Peters bike" + i, "Fields" + i));
                mRides.add(new Ride("Jørgens bike" + i, "Home" + i));
            }
        }
    }

    public List<Ride> getRides() {
        return mRides;
    }

    public void addRide(String what, String where) {
        mLastRide.setBikeName(what);
        mLastRide.setStartRide(where);
    }

    public void endRide(String what, String where) {
        if (mLastRide.getBikeName().equals(what)) {
            mLastRide.setStartRide(where);
            mRides.add(mLastRide);
            mLastRide = new Ride("", "");
        }
    }
}
