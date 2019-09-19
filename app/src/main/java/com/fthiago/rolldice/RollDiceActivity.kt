package com.fthiago.rolldice

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fthiago.rolldice.model.Dice

class RollDiceActivity : AppCompatActivity() {

    private lateinit var diceImage: ImageView

    private lateinit var viewModel: RollDiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roll_dice)

        diceImage = findViewById(R.id.dice_image)
        viewModel = ViewModelProviders.of(this).get(RollDiceViewModel::class.java)
        observeRollDice()
    }

    private fun observeRollDice() {
        viewModel.getDiceValue().observe(this, Observer {
            drawDice(it)
        })
    }

    fun rollDice(view: View) {
        viewModel.rollDice()
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

        diceImage.setImageResource(drawableResource)
    }
}
