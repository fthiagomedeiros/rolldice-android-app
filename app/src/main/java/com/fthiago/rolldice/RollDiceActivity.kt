package com.fthiago.rolldice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fthiago.rolldice.databinding.ActivityRollDiceBinding
import com.fthiago.rolldice.databinding.ActivityRollDiceBindingImpl
import com.fthiago.rolldice.model.Dice

class RollDiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRollDiceBinding
    private lateinit var viewModel: RollDiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_roll_dice)

        setViewModel()
        attachBindingElements()
        observeRollDice()
    }

    private fun attachBindingElements() {
        binding.viewModel = viewModel
    }

    private fun setViewModel() {
        viewModel = ViewModelProviders.of(this).get(RollDiceViewModel::class.java)
    }

    private fun observeRollDice() {
        viewModel.getDiceValue().observe(this, Observer {
            drawDice(it)
        })
    }

    private fun drawDice(dice: Dice) {
        val drawableResource = when(dice.diceValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        binding.diceImage.setImageResource(drawableResource)
    }
}
