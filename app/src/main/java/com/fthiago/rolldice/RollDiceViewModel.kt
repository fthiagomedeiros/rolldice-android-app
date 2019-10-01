package com.fthiago.rolldice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fthiago.rolldice.model.Dice
import java.util.*

class RollDiceViewModel : ViewModel() {

    var mDiceResult: MutableLiveData<Int> = MutableLiveData()
    var imageRes: MutableLiveData<Int> = MutableLiveData()

    fun rollDice() {
        val diceValue = Random().nextInt(6) + 1
        imageRes.value = diceToDraw(Dice(diceValue))
        mDiceResult.value = diceValue
    }

    private fun diceToDraw(dice: Dice): Int {
        return when(dice.diceValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
    }

}