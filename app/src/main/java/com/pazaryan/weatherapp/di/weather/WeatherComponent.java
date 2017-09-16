package com.pazaryan.weatherapp.di.weather;

import com.pazaryan.weatherapp.di.PerPresenter;
import com.pazaryan.weatherapp.presentetion.presenter.weather.WeatherPresenter;

import dagger.Subcomponent;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

@PerPresenter
@Subcomponent(modules = {
        WeatherModule.class,
        LocationModule.class
})
public interface WeatherComponent {

    void inject(WeatherPresenter presenter);

    @Subcomponent.Builder
    interface Builder {
        WeatherComponent build();
    }
}
