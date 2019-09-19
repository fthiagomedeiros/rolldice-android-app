package com.fthiago.rolldice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fthiago.rolldice.model.Dice
import java.util.*

class RollDiceViewModel : ViewModel() {

    val diceValue: MutableLiveData<Dice> = MutableLiveData()

    fun rollDice() {
        val diceValue = Random().nextInt(6) + 1
        this.diceValue.value = Dice(diceValue)
    }

    fun getDiceValue(): LiveData<Dice> {
        return diceValue
    }

}