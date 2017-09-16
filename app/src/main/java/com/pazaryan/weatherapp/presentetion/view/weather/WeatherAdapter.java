package com.pazaryan.weatherapp.presentetion.view.weather;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pazaryan.weatherapp.R;
import com.pazaryan.weatherapp.data.entity.ForeCast;
import com.pazaryan.weatherapp.databinding.ItemWeatherBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Погос Азарян on 12.09.2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherHolder> {

    private List<ForeCast> data;

    public WeatherAdapter() {
        data = new ArrayList<>();
    }

    @Override
    public WeatherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WeatherHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false));
    }

    @Override
    public void onBindViewHolder(WeatherHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<ForeCast> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public static class WeatherHolder extends RecyclerView.ViewHolder {
        private ItemWeatherBinding binding;

        public WeatherHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public void bind(ForeCast foreCast) {
            binding.setForeCast(foreCast);
            binding.executePendingBindings();
        }
    }
}
