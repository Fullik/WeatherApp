package com.pazaryan.weatherapp.presentetion.view.search;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.pazaryan.weatherapp.R;
import com.pazaryan.weatherapp.data.entity.ForeCast;
import com.pazaryan.weatherapp.data.entity.autoComplete.AutoComplete;
import com.pazaryan.weatherapp.databinding.ActivitySearchBinding;
import com.pazaryan.weatherapp.presentetion.presenter.search.SearchPresenter;
import com.pazaryan.weatherapp.presentetion.view.base.BaseActivity;
import com.pazaryan.weatherapp.presentetion.view.weather.WeatherAdapter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class SearchActivity extends BaseActivity implements SearchView, CustomPopUpMenu.OnItemClickedListener {

    @InjectPresenter
    SearchPresenter presenter;
    private ActivitySearchBinding binding;
    private Disposable disposable;
    private CustomPopUpMenu menu;
    private WeatherAdapter weatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        weatherAdapter = new WeatherAdapter();
        binding.recyclerView.setAdapter(weatherAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        disposable = RxTextView.textChangeEvents(binding.searchEditText)
                .skipInitialValue()
                .debounce(300, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(text -> presenter.search(text.text().toString()), Throwable::printStackTrace);

    }

    @Override
    protected void onStop() {
        super.onStop();
        disposable.dispose();
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
        binding.setIsProgressVisible(true);
    }

    @Override
    public void hideProgress() {
        binding.setIsProgressVisible(false);
    }

    @Override
    public void showAutoCompleteResult(List<AutoComplete> autoCompletes) {
        if (menu == null) {
            menu = new CustomPopUpMenu(this);
            menu.setListener(this);
        }

        menu.setData(autoCompletes);
        if (!menu.isShowing()) {
            menu.showAsDropDown(binding.anchor);
        }
    }

    @Override
    public void showSearchProgress() {
        binding.searchProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideSearchProgress() {
        binding.searchProgress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showCountries(List<ForeCast> foreCasts) {
        weatherAdapter.setData(foreCasts);
    }

    @Override
    public void showNoItemMessage() {
        binding.setIsNoItem(true);
    }

    @Override
    public void hideNoItemMessage() {
        binding.setIsNoItem(false);
    }

    @Override
    public void onItemClicked(AutoComplete autoComplete) {
        presenter.getWeather(autoComplete);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (menu != null) {
            menu.dismiss();
        }
    }
}
