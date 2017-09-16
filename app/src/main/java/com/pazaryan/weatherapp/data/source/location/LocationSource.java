package com.pazaryan.weatherapp.data.source.location;

import android.location.Criteria;
import android.location.LocationManager;

import com.pazaryan.weatherapp.data.entity.error.LocationDisabled;
import com.pazaryan.weatherapp.data.source.RxLocationListener;
import com.pazaryan.weatherapp.di.PerPresenter;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Погос Азарян on 12.09.2017.
 */

@PerPresenter
public class LocationSource implements ILocationSource {
    private LocationManager locationManager;
    private RxLocationListener locationListener;

    @Inject
    public LocationSource(LocationManager locationManager, RxLocationListener locationListener) {
        this.locationManager = locationManager;
        this.locationListener = locationListener;
    }

    @Override
    public Observable<String> getLocation() {
        try {
            if (!isLocationEnabled()) {
                return Observable.error(new LocationDisabled());
            }
            locationManager.requestSingleUpdate(setupProvider(), locationListener, null);
            return locationListener.observeLocationChange()
                    .doOnDispose(() -> locationManager.removeUpdates(locationListener));
        } catch (SecurityException e) {
            return Observable.error(e);
        }
    }

    public boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    private String setupProvider() {
        Criteria criteria = new Criteria();
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        return locationManager.getBestProvider(criteria, true);
    }

}
