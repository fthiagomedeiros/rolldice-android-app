package com.fthiago.rolldice.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class DataBindingAdapters {

    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageView, int resource){
        imageView.setImageResource(resource);
    }
}