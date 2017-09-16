package com.pazaryan.weatherapp.presentetion.view.weather;

import com.pazaryan.weatherapp.data.entity.ForeCast;
import com.pazaryan.weatherapp.presentetion.view.base.BaseView;

import java.util.List;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

public interface WeatherView extends BaseView {
    void hidePermissionError();

    void showPermissionError();

    void showLocationDisabledError();

    void hideLocationDisabledError();

    void setData(List<ForeCast> foreCasts);
}
