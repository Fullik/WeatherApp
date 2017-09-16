package com.pazaryan.weatherapp.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

public class ForeCast {
    @SerializedName("date")
    private ForeCastDate foreCastDate;

    @SerializedName("high")
    private Temperature highTemperature;

    @SerializedName("low")
    private Temperature lowTemperature;

    @SerializedName("icon_url")
    private String iconUrl;

    public String getIconUrl() {
        return iconUrl;
    }

    public long getForeCastDate() {
        return foreCastDate.getEpoch() * 1000;
    }

    public double getHighTemperature() {
        return highTemperature.getCelsius();
    }

    public double getLowTemperature() {
        return lowTemperature.getCelsius();
    }
}
