package com.pazaryan.weatherapp.di.retrofit;

import com.pazaryan.weatherapp.data.entity.autoComplete.AutoComplete;

import java.util.List;
import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Погос Азарян on 14.09.2017.
 */

public interface AutoCompleteApi {
    @GET("aq")
    Single<Map<String, List<AutoComplete>>> getCountries(@Query("query") String query);
}
