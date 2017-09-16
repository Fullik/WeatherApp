package com.pazaryan.weatherapp.data.source.autoComplete;

import com.pazaryan.weatherapp.data.entity.autoComplete.AutoComplete;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Погос Азарян on 14.09.2017.
 */

public interface IAutoCompleteSource {
    Single<List<AutoComplete>> search(String query);
}
