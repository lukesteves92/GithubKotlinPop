package com.challenge.kotlinpop.main.application

import android.app.Application
import com.challenge.kotlinpop.di.main.initializeKoin
import org.koin.android.ext.koin.androidContext

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin {
            androidContext(this@BaseApplication)
        }
    }
}