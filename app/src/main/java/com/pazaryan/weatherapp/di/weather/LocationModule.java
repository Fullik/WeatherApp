package com.pazaryan.weatherapp.di.weather;

import android.content.Context;
import android.location.LocationManager;

import com.pazaryan.weatherapp.data.repository.location.ILocationRepository;
import com.pazaryan.weatherapp.data.repository.location.LocationRepository;
import com.pazaryan.weatherapp.data.source.location.ILocationSource;
import com.pazaryan.weatherapp.data.source.location.LocationSource;
import com.pazaryan.weatherapp.data.source.RxLocationListener;
import com.pazaryan.weatherapp.di.PerPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Погос Азарян on 12.09.2017.
 */

@Module
public abstract class LocationModule {
    @Provides
    @PerPresenter
    static LocationManager provideLocationManager(Context context) {
        return (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    @Provides
    @PerPresenter
    static RxLocationListener provideLocationListener() {
        return new RxLocationListener();
    }

    @Binds
    @PerPresenter
    abstract ILocationRepository provideLocationRepository(LocationRepository repository);

    @Binds
    @PerPresenter
    abstract ILocationSource provideLocationSource(LocationSource locationSource);
}
