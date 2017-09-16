package com.pazaryan.weatherapp.di.search;

import com.pazaryan.weatherapp.buisiness.search.ISearchInteractor;
import com.pazaryan.weatherapp.buisiness.search.SearchInteractor;
import com.pazaryan.weatherapp.di.PerPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Погос Азарян on 14.09.2017.
 */

@Module
public abstract class SearchModule {

    @Binds
    @PerPresenter
    abstract ISearchInteractor provideSearchInteractor(SearchInteractor searchInteractor);
}
