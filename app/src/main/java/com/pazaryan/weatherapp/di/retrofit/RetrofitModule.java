package com.pazaryan.weatherapp.di.retrofit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

@Module
public abstract class RetrofitModule {

    @Provides
    @Singleton
    static OkHttpClient provideClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    @Singleton
    @Named("API")
    static Retrofit provideRetrofitApi(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(Urls.API_URL + Urls.API_KEY + "/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @Named("AUTO")
    static Retrofit provideRetrofitAuto(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(Urls.AUTO_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    static WeatherApi provideWeatherApi(@Named("API") Retrofit retrofit) {
        return retrofit.create(WeatherApi.class);
    }

    @Provides
    @Singleton
    static AutoCompleteApi provideAutoCompleteApi(@Named("AUTO") Retrofit retrofit) {
        return retrofit.create(AutoCompleteApi.class);
    }

}
