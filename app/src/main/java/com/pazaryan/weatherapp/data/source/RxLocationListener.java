package com.pazaryan.weatherapp.data.source;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Погос Азарян on 12.09.2017.
 */

public class RxLocationListener implements LocationListener {
    private PublishSubject<String> subject;

    public RxLocationListener() {
        subject = PublishSubject.create();
    }

    @Override
    public void onLocationChanged(Location location) {
        subject.onNext(location.getLatitude() + "," + location.getLongitude());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public Observable<String> observeLocationChange() {
        return subject;
    }
}
