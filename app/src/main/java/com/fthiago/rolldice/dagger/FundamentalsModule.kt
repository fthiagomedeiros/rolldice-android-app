package com.fthiago.rolldice.dagger

import android.app.Application
import android.content.Context
import com.fthiago.rolldice.model.Info
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideInfo(): Info = Info()
}