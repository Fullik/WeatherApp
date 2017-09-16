package com.pazaryan.weatherapp.data.entity.autoComplete;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Погос Азарян on 14.09.2017.
 */

public class AutoComplete {
    @SerializedName("name")
    private String name;
    @SerializedName("lat")
    private double latitude;
    @SerializedName("lon")
    private double longtitude;

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }
}
