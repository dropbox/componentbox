package com.dropbox.componentbox.android

import android.app.Application
import com.airbnb.mvrx.Mavericks
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ComponentBoxApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}