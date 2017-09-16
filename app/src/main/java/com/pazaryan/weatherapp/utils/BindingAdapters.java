package com.pazaryan.weatherapp.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Погос Азарян on 12.09.2017.
 */

public class BindingAdapters {

    @BindingAdapter("bind:loadImage")
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    @BindingAdapter("bind:setDate")
    public static void setDate(TextView textView, long epoch) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        textView.setText(sdf.format(new Date(epoch)));
    }
}
