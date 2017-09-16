package com.pazaryan.weatherapp.data.repository.autoComplete;

import com.pazaryan.weatherapp.data.entity.autoComplete.AutoComplete;
import com.pazaryan.weatherapp.data.source.autoComplete.IAutoCompleteSource;
import com.pazaryan.weatherapp.di.PerPresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Погос Азарян on 14.09.2017.
 */

@PerPresenter
public class AutoCompleteRepository implements IAutoCompleteRepository {
    private IAutoCompleteSource autoCompleteSource;

    @Inject
    public AutoCompleteRepository(IAutoCompleteSource autoCompleteSource) {
        this.autoCompleteSource = autoCompleteSource;
    }

    @Override
    public Single<List<AutoComplete>> getCountries(String query) {
        return autoCompleteSource.search(query);
    }
}
