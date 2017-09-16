package com.pazaryan.weatherapp.presentetion.view.search;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pazaryan.weatherapp.R;
import com.pazaryan.weatherapp.data.entity.autoComplete.AutoComplete;
import com.pazaryan.weatherapp.databinding.ItemCountryBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Погос Азарян on 14.09.2017.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<AutoComplete> items;
    private OnItemClickedListener listener;

    public CountryAdapter(OnItemClickedListener listener) {
        this.items = new ArrayList<>();
        this.listener = listener;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CountryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false));
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        holder.bind(items.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void setData(List<AutoComplete> data) {
        this.items = data;
        notifyDataSetChanged();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        private ItemCountryBinding binding;

        public CountryViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public void bind(AutoComplete autoComplete, OnItemClickedListener listener) {
            binding.getRoot().setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClicked(autoComplete);
                }
            });
            binding.name.setText(autoComplete.getName());
            binding.executePendingBindings();
        }
    }

    public interface OnItemClickedListener {
        void onItemClicked(AutoComplete autoComplete);
    }
}
