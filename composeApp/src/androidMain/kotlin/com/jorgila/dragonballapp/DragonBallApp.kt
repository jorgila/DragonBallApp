package com.jorgila.dragonballapp

import android.app.Application
import com.jorgila.dragonballapp.di.initKoin
import com.jorgila.dragonballapp.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DragonBallApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            extraModules = listOf(uiModule),
            config = {
                androidLogger()
                androidContext(this@DragonBallApp)
            })
    }

}