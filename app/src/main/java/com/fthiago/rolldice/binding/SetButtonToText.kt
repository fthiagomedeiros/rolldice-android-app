package com.fthiago.rolldice.binding

import android.widget.Button
import androidx.databinding.BindingAdapter

object SetButtonToText {

    @BindingAdapter("setButtonToText")
    @JvmStatic
    fun SetButtonToText(view: Button, text: String) {
        view.text = text
    }

}