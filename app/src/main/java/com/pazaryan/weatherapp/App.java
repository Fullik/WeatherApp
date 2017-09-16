package com.pazaryan.weatherapp;

import android.app.Application;

import com.pazaryan.weatherapp.di.ComponentHolder;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ComponentHolder.getInstance().buildAppComponent(this);
    }
}
