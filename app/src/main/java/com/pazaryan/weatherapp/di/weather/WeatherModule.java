package com.pazaryan.weatherapp.di.weather;

import com.pazaryan.weatherapp.buisiness.weather.IWeatherInteractor;
import com.pazaryan.weatherapp.buisiness.weather.WeatherInteractor;
import com.pazaryan.weatherapp.data.repository.weather.IWeatherRepository;
import com.pazaryan.weatherapp.data.repository.weather.WeatherRepository;
import com.pazaryan.weatherapp.di.PerPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

@Module
public abstract class WeatherModule {

    @Binds
    @PerPresenter
    abstract IWeatherRepository provideWeatherRepository(WeatherRepository weatherRepository);

    @Binds
    @PerPresenter
    abstract IWeatherInteractor provideWeatherInteractor(WeatherInteractor weatherInteractor);
}
