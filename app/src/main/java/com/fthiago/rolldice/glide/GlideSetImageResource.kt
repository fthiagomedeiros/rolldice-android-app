package com.fthiago.rolldice.glide

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object GlideSetImageResource {

    @BindingAdapter("setImageResource")
    @JvmStatic
    fun setImageResource(view: ImageView, imageUrl: String) {
        val context: Context = view.context

        Glide.with(context)
            .load(imageUrl)
            .into(view)

    }

}