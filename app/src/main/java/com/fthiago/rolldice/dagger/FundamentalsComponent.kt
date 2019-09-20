package com.fthiago.rolldice.dagger

import com.fthiago.rolldice.activities.RollDiceActivity
import com.fthiago.rolldice.application.RollDiceApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface FundamentalsComponent {
    fun inject(app: RollDiceApplication)
    fun inject(app: RollDiceActivity)
}