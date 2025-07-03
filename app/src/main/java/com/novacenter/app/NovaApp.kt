package com.novacenter.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class NovaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}
