package com.pazaryan.weatherapp.data.source.autoComplete;

import com.pazaryan.weatherapp.data.entity.autoComplete.AutoComplete;
import com.pazaryan.weatherapp.di.PerPresenter;
import com.pazaryan.weatherapp.di.retrofit.AutoCompleteApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Погос Азарян on 14.09.2017.
 */

@PerPresenter
public class AutoCompleteSource implements IAutoCompleteSource {
    private AutoCompleteApi autoCompleteApi;

    @Inject
    public AutoCompleteSource(AutoCompleteApi autoCompleteApi) {
        this.autoCompleteApi = autoCompleteApi;
    }

    @Override
    public Single<List<AutoComplete>> search(String query) {
        return autoCompleteApi.getCountries(query)
                .subscribeOn(Schedulers.newThread())
                .map(map -> map.get("RESULTS"));
    }
}
