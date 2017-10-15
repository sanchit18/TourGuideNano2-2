package com.udacity.sanchitsharma.tourguidenano;
import android.graphics.drawable.Drawable;
import android.location.Location;

/**
 * Created by sanchitsharma on 10/10/17.
 */

public class Place {
    private String mName;
    private String mPhone;
    private String mAddress;
    private Drawable mImage;
    private Location mLocation;
    public Place(String name, String phone, String address, Drawable image, Location location) {
        mName = name;
        mPhone = phone;
        mAddress = address;
        mImage = image;
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
    public Drawable getImage() {
        return mImage;
    }
}

