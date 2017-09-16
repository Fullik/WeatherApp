package com.pazaryan.weatherapp.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

public class WeatherResponse {
    @SerializedName("forecast")
    private SimpleForecast simpleForcast;

    public SimpleForecast getSimpleForcast() {
        return simpleForcast;
    }
}
