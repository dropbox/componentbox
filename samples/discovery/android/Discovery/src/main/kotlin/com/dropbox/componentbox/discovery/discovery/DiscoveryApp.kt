package com.dropbox.componentbox.discovery.discovery

import android.app.Application
import com.airbnb.mvrx.Mavericks
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DiscoveryApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}