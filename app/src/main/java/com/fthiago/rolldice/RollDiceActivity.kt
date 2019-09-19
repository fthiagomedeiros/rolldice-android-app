package com.fthiago.rolldice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fthiago.rolldice.databinding.ActivityRollDiceBinding

class RollDiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRollDiceBinding
    private lateinit var viewModel: RollDiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_roll_dice)

        setViewModel()
        bindViewModel()
        observeImageToDraw()
    }

    private fun bindViewModel() {
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
