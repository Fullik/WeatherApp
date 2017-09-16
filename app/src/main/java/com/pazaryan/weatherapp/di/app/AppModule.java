package com.pazaryan.weatherapp.di.app;

import android.content.Context;

import com.pazaryan.weatherapp.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return app;
    }
}
