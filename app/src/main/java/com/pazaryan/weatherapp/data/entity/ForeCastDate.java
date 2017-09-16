package com.pazaryan.weatherapp.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

public class ForeCastDate {
    @SerializedName("epoch")
    private long epoch;

    public long getEpoch() {
        return epoch;
    }
}
