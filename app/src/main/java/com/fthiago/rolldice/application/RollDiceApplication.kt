package com.fthiago.rolldice.application

import android.app.Application
import com.fthiago.rolldice.dagger.AppModule
import com.fthiago.rolldice.dagger.DaggerFundamentalsComponent
import com.fthiago.rolldice.dagger.FundamentalsComponent

class RollDiceApplication : Application() {

    private lateinit var daggerComponent: FundamentalsComponent

    override fun onCreate() {
        super.onCreate()
        daggerComponent = DaggerFundamentalsComponent.builder().appModule(AppModule(this)).build()
        daggerComponent.inject(this)
    }

    fun getComponentFromDagger(): FundamentalsComponent {
        return daggerComponent
    }
}