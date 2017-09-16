package com.pazaryan.weatherapp.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerPresenter {
}
