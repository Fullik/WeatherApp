package com.pazaryan.weatherapp.data.source.location;

import io.reactivex.Observable;

/**
 * Created by Погос Азарян on 12.09.2017.
 */

public interface ILocationSource {
    Observable<String> getLocation();
}
