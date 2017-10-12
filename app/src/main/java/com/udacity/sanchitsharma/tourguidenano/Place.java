package com.udacity.sanchitsharma.tourguidenano;
import android.location.Location;

/**
 * Created by sanchitsharma on 10/10/17.
 */

public class Place {
    private String mName;
    private String mPhone;
    private String mAddress;
    private String mUrl;
    private Location mLocation;
    public Place(String name, String phone, String address, String imageUrl, Location location) {
        mName = name;
        mPhone = phone;
        mAddress = address;
        mUrl = imageUrl;
        mLocation = location;
    }
    public String getName() {
        return mName;
    }
    public String getPhone() {
        return mPhone;
    }
    public Location getLocation() {
        return mLocation;
    }
    public String getAddress() {
        return mAddress;
    }
    public String getUrl() {
        return mUrl;
    }
}

