package com.fthiago.rolldice

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders

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
        viewModel.getDiceValue().observe(this, androidx.lifecycle.Observer {
            Toast.makeText(this, "Funcionou $it", Toast.LENGTH_LONG).show()
            drawDice(it)
        })
    }

    fun rollDice(view: View) {
        viewModel.rollDice()
    }

    private fun drawDice(diceValue: Int) {
        val drawableResource = when(diceValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }
}
