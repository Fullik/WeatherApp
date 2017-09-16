package com.pazaryan.weatherapp.data.repository.weather;

import com.pazaryan.weatherapp.data.entity.ForeCast;
import com.pazaryan.weatherapp.di.PerPresenter;
import com.pazaryan.weatherapp.di.retrofit.WeatherApi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

@PerPresenter
public class WeatherRepository implements IWeatherRepository {
    private WeatherApi weatherApi;

    @Inject
    public WeatherRepository(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }


    @Override
    public Single<List<ForeCast>> getWeather(String query) {
        return weatherApi.getWeather(query)
                .subscribeOn(Schedulers.newThread())
                .map(weatherResponse -> {
                    if (weatherResponse.getSimpleForcast() == null) {
                        return new ArrayList<ForeCast>();
                    } else {
                     return weatherResponse.getSimpleForcast().getForeCastDay().getForeCasts();
                    }
                });
    }
}
