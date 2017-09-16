package com.pazaryan.weatherapp.presentetion.presenter.weather;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.pazaryan.weatherapp.buisiness.weather.IWeatherInteractor;
import com.pazaryan.weatherapp.data.entity.error.LocationDisabled;
import com.pazaryan.weatherapp.di.ComponentHolder;
import com.pazaryan.weatherapp.presentetion.view.weather.WeatherView;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

@InjectViewState
public class WeatherPresenter extends MvpPresenter<WeatherView> {
    @Inject
    IWeatherInteractor weatherInteractor;
    private Disposable disposable;

    public WeatherPresenter() {
        ComponentHolder.getInstance().buildWeatherComponent().inject(this);
    }

    @Override
    public void onDestroy() {
        ComponentHolder.getInstance().releaseWeatherComponent();
        dispose();
    }

    public void getWeather() {
        dispose();
        disposable = weatherInteractor.getWeather()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(dis -> getViewState().setData(new ArrayList<>()))
                .doOnSubscribe(disposable -> {
                    getViewState().showProgress();
                    getViewState().hidePermissionError();
                    getViewState().hideLocationDisabledError();
                })
                .subscribe(foreCasts -> {
                    getViewState().setData(foreCasts);
                    getViewState().hideProgress();
                }, this::handleError);
    }

    private void dispose() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    private void handleError(Throwable throwable) {
        if (throwable instanceof SecurityException) {
            getViewState().showPermissionError();
            return;
        }
        if (throwable instanceof LocationDisabled) {
            getViewState().showLocationDisabledError();
            return;
        }
        getViewState().hideProgress();
        throwable.printStackTrace();
        getViewState().showMessage(throwable.getMessage());
    }
}
