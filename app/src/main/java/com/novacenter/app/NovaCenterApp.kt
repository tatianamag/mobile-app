package com.novacenter.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class NovaCenterApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}
