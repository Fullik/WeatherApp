package com.pazaryan.weatherapp.data.repository.weather;

import com.pazaryan.weatherapp.data.entity.ForeCast;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

public interface IWeatherRepository {

    Single<List<ForeCast>> getWeather(String query);

}
