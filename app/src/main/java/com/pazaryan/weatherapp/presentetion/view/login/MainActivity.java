package com.pazaryan.weatherapp.presentetion.view.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pazaryan.weatherapp.R;
import com.pazaryan.weatherapp.databinding.ActivityMainBinding;
import com.pazaryan.weatherapp.presentetion.view.search.SearchActivity;
import com.pazaryan.weatherapp.presentetion.view.weather.WeatherActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.currentWeather.setOnClickListener(v -> startActivity(new Intent(this, WeatherActivity.class)));
        binding.searchWeather.setOnClickListener(v -> startActivity(new Intent(this, SearchActivity.class)));
    }
}
