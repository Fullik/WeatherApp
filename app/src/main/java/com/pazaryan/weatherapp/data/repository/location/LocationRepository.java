package com.pazaryan.weatherapp.data.repository.location;

import com.pazaryan.weatherapp.data.source.location.ILocationSource;
import com.pazaryan.weatherapp.di.PerPresenter;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Погос Азарян on 12.09.2017.
 */

@PerPresenter
public class LocationRepository implements ILocationRepository {
    private ILocationSource locationSource;

    @Inject
    public LocationRepository(ILocationSource locationSource) {
        this.locationSource = locationSource;
    }

    @Override
    public Observable<String> getLocation() {
        return locationSource.getLocation();
    }
}
