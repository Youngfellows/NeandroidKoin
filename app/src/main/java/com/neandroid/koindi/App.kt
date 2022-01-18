package com.neandroid.koindi

import android.app.Application
import com.neandroid.koindi.di.coffeeMakerModule
import com.neandroid.koindi.di.coffeeMakerModule1
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class App : Application() {

    override fun onCreate() {
        initKoin()
        super.onCreate()
    }

    fun initKoin() {
        startKoin {
            //androidLogger(Level.INFO)
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(coffeeMakerModule1, coffeeMakerModule)
        }
    }
}