package com.pazaryan.weatherapp.presentetion.view.base;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

public interface BaseView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showMessage(String message);

    void showProgress();

    void hideProgress();
}
