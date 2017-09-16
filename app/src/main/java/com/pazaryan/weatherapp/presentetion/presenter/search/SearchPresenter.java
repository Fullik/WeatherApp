package com.pazaryan.weatherapp.presentetion.presenter.search;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.pazaryan.weatherapp.buisiness.search.ISearchInteractor;
import com.pazaryan.weatherapp.data.entity.autoComplete.AutoComplete;
import com.pazaryan.weatherapp.di.ComponentHolder;
import com.pazaryan.weatherapp.presentetion.view.search.SearchView;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by Погос Азарян on 14.09.2017.
 */

@InjectViewState
public class SearchPresenter extends MvpPresenter<SearchView> {

    @Inject
    ISearchInteractor searchInteractor;

    public SearchPresenter() {
        ComponentHolder.getInstance().buildSearchComponent().inject(this);
    }

    public void search(String query) {
        if (query.isEmpty()) {
            getViewState().showAutoCompleteResult(new ArrayList<>());
            return;
        }
        searchInteractor.getCountries(query)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getViewState().showSearchProgress())
                .doFinally(() -> getViewState().hideSearchProgress())
                .subscribe(autoCompletes -> getViewState().showAutoCompleteResult(autoCompletes),
                        throwable -> getViewState().showMessage(throwable.getMessage()));
    }

    @Override
    public void onDestroy() {
        ComponentHolder.getInstance().releaseSearchComponent();
    }

    public void getWeather(AutoComplete autoComplete) {
        searchInteractor.getWeather(autoComplete)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
                    getViewState().showProgress();
                    getViewState().hideNoItemMessage();
                })
                .doFinally(() -> getViewState().hideProgress())
                .subscribe(foreCasts -> {
                            if (foreCasts.size() == 0) {
                                getViewState().showNoItemMessage();
                            }
                            getViewState().showCountries(foreCasts);
                        },
                        throwable -> getViewState().showMessage(throwable.getMessage()));
    }
}
