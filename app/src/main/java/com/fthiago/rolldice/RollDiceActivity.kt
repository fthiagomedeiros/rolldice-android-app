package com.fthiago.rolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

class RollDiceActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        setRollDiceButton()
    }

    private fun setRollDiceButton() {
        val rollButton: Button = findViewById(R.id.roll_dice_button)
        rollButton.setOnClickListener {
            val diceValue = rollDice()
            drawDice(diceValue)
        }
    }

    private fun rollDice(): Int {
        return Random().nextInt(6) + 1
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
