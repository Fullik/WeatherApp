package com.pazaryan.weatherapp.di.app;

import com.pazaryan.weatherapp.di.retrofit.RetrofitModule;
import com.pazaryan.weatherapp.di.search.SearchComponent;
import com.pazaryan.weatherapp.di.weather.WeatherComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        RetrofitModule.class
})
public interface AppComponent {
    WeatherComponent.Builder weatherComponentBuilder();

    SearchComponent.Builder searchComponentBuilder();
}
