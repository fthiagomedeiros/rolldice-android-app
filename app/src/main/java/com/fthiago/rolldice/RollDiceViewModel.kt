package com.fthiago.rolldice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class RollDiceViewModel : ViewModel() {

    val diceValue: MutableLiveData<Int> = MutableLiveData()

    fun rollDice() {
        val diceValue = Random().nextInt(6) + 1
        this.diceValue.value = diceValue
    }

    fun getDiceValue(): LiveData<Int> {
        return diceValue
    }

}