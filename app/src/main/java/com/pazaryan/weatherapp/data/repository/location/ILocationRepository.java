package com.pazaryan.weatherapp.data.repository.location;

import io.reactivex.Observable;

/**
 * Created by Погос Азарян on 12.09.2017.
 */

public interface ILocationRepository {
    Observable<String> getLocation();
}
