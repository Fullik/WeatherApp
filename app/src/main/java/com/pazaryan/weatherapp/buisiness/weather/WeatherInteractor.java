package com.pazaryan.weatherapp.buisiness.weather;

import com.pazaryan.weatherapp.data.entity.ForeCast;
import com.pazaryan.weatherapp.data.repository.location.ILocationRepository;
import com.pazaryan.weatherapp.data.repository.weather.IWeatherRepository;
import com.pazaryan.weatherapp.di.PerPresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

@PerPresenter
public class WeatherInteractor implements IWeatherInteractor {
    private IWeatherRepository weatherRepository;
    private ILocationRepository locationRepository;

    @Inject
    public WeatherInteractor(IWeatherRepository weatherRepository, ILocationRepository locationRepository) {
        this.weatherRepository = weatherRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public Observable<List<ForeCast>> getWeather() {
        return locationRepository.getLocation()
                .flatMap(location -> weatherRepository.getWeather(location)
                        .toObservable());
    }
}
