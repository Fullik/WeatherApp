package com.pazaryan.weatherapp.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

public class Temperature {
    @SerializedName("fahrenheit")
    private double fahrenheit;

    @SerializedName("celsius")
    private double celsius;

    public double getFahrenheit() {
        return fahrenheit;
    }

    public double getCelsius() {
        return celsius;
    }
}
