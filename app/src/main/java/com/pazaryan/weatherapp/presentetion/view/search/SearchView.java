package com.pazaryan.weatherapp.presentetion.view.search;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.pazaryan.weatherapp.data.entity.ForeCast;
import com.pazaryan.weatherapp.data.entity.autoComplete.AutoComplete;
import com.pazaryan.weatherapp.presentetion.view.base.BaseView;

import java.util.List;

/**
 * Created by Погос Азарян on 14.09.2017.
 */

public interface SearchView extends BaseView {
    @StateStrategyType(SkipStrategy.class)
    void showAutoCompleteResult(List<AutoComplete> autoCompletes);

    void showSearchProgress();

    void hideSearchProgress();

    void showCountries(List<ForeCast> foreCasts);

    void showNoItemMessage();

    void hideNoItemMessage();
}
