package com.planetsystems.events

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        appResources = resources
    }

    companion object {
        lateinit var appContext: Context
            private set
        lateinit var appResources: Resources
            private set
    }
}