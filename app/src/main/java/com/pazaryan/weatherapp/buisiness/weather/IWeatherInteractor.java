package com.pazaryan.weatherapp.buisiness.weather;

import com.pazaryan.weatherapp.data.entity.ForeCast;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

public interface IWeatherInteractor {
    Observable<List<ForeCast>> getWeather();
}
