package com.pazaryan.weatherapp.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

public class SimpleForecast {
    @SerializedName("simpleforecast")
    private ForeCastDay foreCastDay;

    public ForeCastDay getForeCastDay() {
        return foreCastDay;
    }
}
