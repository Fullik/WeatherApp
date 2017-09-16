package com.pazaryan.weatherapp.buisiness.search;

import com.pazaryan.weatherapp.data.entity.ForeCast;
import com.pazaryan.weatherapp.data.entity.autoComplete.AutoComplete;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Погос Азарян on 14.09.2017.
 */

public interface ISearchInteractor {
    Single<List<AutoComplete>> getCountries(String query);

    Single<List<ForeCast>> getWeather(AutoComplete autoComplete);
}
