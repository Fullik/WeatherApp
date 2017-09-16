package com.pazaryan.weatherapp.di.retrofit;

import com.pazaryan.weatherapp.data.entity.WeatherResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

public interface WeatherApi {
    @GET("forecast10day/q/{query}.json")
    Single<WeatherResponse> getWeather(@Path("query") String query);
}
