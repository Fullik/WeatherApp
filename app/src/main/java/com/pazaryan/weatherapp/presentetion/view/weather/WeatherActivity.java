package com.pazaryan.weatherapp.presentetion.view.weather;

import android.Manifest;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.pazaryan.weatherapp.R;
import com.pazaryan.weatherapp.data.entity.ForeCast;
import com.pazaryan.weatherapp.databinding.ActivityWeatherBinding;
import com.pazaryan.weatherapp.presentetion.presenter.weather.WeatherPresenter;
import com.pazaryan.weatherapp.presentetion.view.base.BaseActivity;

import java.util.List;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.PermissionUtils;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class WeatherActivity extends BaseActivity
        implements WeatherView {

    @InjectPresenter
    WeatherPresenter presenter;
    private ActivityWeatherBinding binding;
    private WeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather);
        binding.permissionButton.setOnClickListener(v -> WeatherActivityPermissionsDispatcher.getWeatherWithCheck(this));
        binding.locationButton.setOnClickListener(v -> presenter.getWeather());
        binding.swipeRefresh.setOnRefreshListener(() -> presenter.getWeather());
        binding.setIsLocationErrorVisible(false);
        binding.setIsPermissionErrorVisible(false);
        setupAdapter();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupAdapter() {
        adapter = new WeatherAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        binding.setIsPermissionErrorVisible(!PermissionUtils.hasSelfPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION));
        if (PermissionUtils.hasSelfPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION) && adapter.getItemCount() == 0) {
            getWeather();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgress() {
        binding.swipeRefresh.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        binding.swipeRefresh.setRefreshing(false);
    }

    @NeedsPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    void getWeather() {
        presenter.getWeather();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        WeatherActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnNeverAskAgain(Manifest.permission.ACCESS_FINE_LOCATION)
    void onNeverAsk() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.never_ask_selected)
                .setPositiveButton(R.string.ok, (dialogInterface, i) -> {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                })
                .setNegativeButton(R.string.cancel, (dialogInterface, i) -> {})
                .show();
    }

    @Override
    public void hidePermissionError() {
        binding.setIsPermissionErrorVisible(false);
    }

    @Override
    public void showPermissionError() {
        binding.setIsPermissionErrorVisible(true);
    }

    @Override
    public void showLocationDisabledError() {
        binding.setIsLocationErrorVisible(true);
    }

    @Override
    public void hideLocationDisabledError() {
        binding.setIsLocationErrorVisible(false);
    }

    @Override
    public void setData(List<ForeCast> foreCasts) {
        adapter.setData(foreCasts);
    }
}
