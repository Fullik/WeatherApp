package com.pazaryan.weatherapp.di.search;

import com.pazaryan.weatherapp.di.PerPresenter;
import com.pazaryan.weatherapp.di.weather.WeatherModule;
import com.pazaryan.weatherapp.presentetion.presenter.search.SearchPresenter;

import dagger.Subcomponent;

/**
 * Created by Погос Азарян on 14.09.2017.
 */

@PerPresenter
@Subcomponent(modules = {
        WeatherModule.class,
        AutoCompleteModule.class,
        SearchModule.class
})
public interface SearchComponent {

    void inject(SearchPresenter searchPresenter);

    @Subcomponent.Builder
    public interface Builder {
        SearchComponent build();
    }
}
