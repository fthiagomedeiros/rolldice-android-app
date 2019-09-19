package com.fthiago.rolldice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fthiago.rolldice.databinding.ActivityRollDiceBinding
import com.fthiago.rolldice.databinding.ActivityRollDiceBindingImpl
import com.fthiago.rolldice.model.Dice
import androidx.databinding.BindingAdapter
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.ImageView
import org.antlr.runtime.misc.IntArray



class RollDiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRollDiceBinding
    private lateinit var viewModel: RollDiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_roll_dice)

        setViewModel()
        attachBindingElements()
        observeImageToDraw()
    }

    private fun attachBindingElements() {
        binding.viewModel = viewModel
    }

    private fun setViewModel() {
        viewModel = ViewModelProviders.of(this).get(RollDiceViewModel::class.java)
    }

    private fun observeImageToDraw() {
        viewModel.getImageToDraw().observe(this, Observer {
            binding.diceImage.setImageResource(it)
        })
    }

}
