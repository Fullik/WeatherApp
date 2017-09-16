package com.pazaryan.weatherapp.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

public class ForeCastDay {
    @SerializedName("forecastday") List<ForeCast> foreCasts;

    public List<ForeCast> getForeCasts() {
        return foreCasts;
    }
}
