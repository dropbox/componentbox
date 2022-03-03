package com.dropbox.componentbox.samples.discovery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dropbox.componentbox.samples.discovery.ui.scaffold.Scaffold
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoveryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = RealInflater()
        setContent {
            discoveryTheme(false) {
                Scaffold(inflater)
            }
        }
    }
}