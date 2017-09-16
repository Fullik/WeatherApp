package com.pazaryan.weatherapp.presentetion.view.base;

import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;

/**
 * Created by Погос Азарян on 11.09.2017.
 */

public abstract class BaseActivity extends MvpAppCompatActivity
    implements BaseView {

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
