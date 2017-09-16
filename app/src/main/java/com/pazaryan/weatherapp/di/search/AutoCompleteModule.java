package com.pazaryan.weatherapp.di.search;

import com.pazaryan.weatherapp.data.repository.autoComplete.AutoCompleteRepository;
import com.pazaryan.weatherapp.data.repository.autoComplete.IAutoCompleteRepository;
import com.pazaryan.weatherapp.data.source.autoComplete.AutoCompleteSource;
import com.pazaryan.weatherapp.data.source.autoComplete.IAutoCompleteSource;
import com.pazaryan.weatherapp.di.PerPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Погос Азарян on 14.09.2017.
 */

@Module
public abstract class AutoCompleteModule {

    @Binds
    @PerPresenter
    abstract IAutoCompleteRepository provideAutoCompleteRepository(AutoCompleteRepository autoCompleteRepository);

    @Binds
    @PerPresenter
    abstract IAutoCompleteSource provideAutoCompleteSource(AutoCompleteSource autoCompleteSource);
}
