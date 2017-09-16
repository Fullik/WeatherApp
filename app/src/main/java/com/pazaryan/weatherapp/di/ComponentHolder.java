package com.pazaryan.weatherapp.di;

import com.pazaryan.weatherapp.App;
import com.pazaryan.weatherapp.di.app.AppComponent;
import com.pazaryan.weatherapp.di.app.AppModule;
import com.pazaryan.weatherapp.di.app.DaggerAppComponent;
import com.pazaryan.weatherapp.di.search.SearchComponent;
import com.pazaryan.weatherapp.di.weather.WeatherComponent;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

public class ComponentHolder {
    private static ComponentHolder INSTANCE;
    private AppComponent appComponent;
    private WeatherComponent weatherComponent;
    private SearchComponent searchComponent;

    private ComponentHolder() {
    }

    public static ComponentHolder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ComponentHolder();
        }
        return INSTANCE;
    }

    public void buildAppComponent(App app) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(app))
                .build();
    }

    public WeatherComponent buildWeatherComponent() {
        if (weatherComponent == null) {
            weatherComponent = appComponent.weatherComponentBuilder()
                    .build();
        }

        return weatherComponent;
    }

    public SearchComponent buildSearchComponent() {
        if (searchComponent == null) {
            searchComponent = appComponent.searchComponentBuilder()
                    .build();
        }

        return searchComponent;
    }

    public void releaseSearchComponent() {
        searchComponent = null;
    }

    public void releaseWeatherComponent() {
        weatherComponent = null;
    }
}
