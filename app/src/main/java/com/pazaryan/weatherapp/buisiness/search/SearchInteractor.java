package com.pazaryan.weatherapp.buisiness.search;

import com.pazaryan.weatherapp.data.entity.ForeCast;
import com.pazaryan.weatherapp.data.entity.autoComplete.AutoComplete;
import com.pazaryan.weatherapp.data.repository.autoComplete.IAutoCompleteRepository;
import com.pazaryan.weatherapp.data.repository.weather.IWeatherRepository;
import com.pazaryan.weatherapp.di.PerPresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Погос Азарян on 14.09.2017.
 */

@PerPresenter
public class SearchInteractor implements ISearchInteractor {
    private IWeatherRepository weatherRepository;
    private IAutoCompleteRepository autoCompleteRepository;

    @Inject
    public SearchInteractor(IWeatherRepository weatherRepository, IAutoCompleteRepository autoCompleteRepository) {
        this.weatherRepository = weatherRepository;
        this.autoCompleteRepository = autoCompleteRepository;
    }

    @Override
    public Single<List<AutoComplete>> getCountries(String query) {
        return autoCompleteRepository.getCountries(query);
    }

    @Override
    public Single<List<ForeCast>> getWeather(AutoComplete autoComplete) {
        return weatherRepository.getWeather(autoComplete.getName());
    }
}
