package com.dropbox.componentbox.discovery.discovery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dropbox.componentbox.discovery.discovery.scaffold.Scaffold
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoveryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiscoveryTheme(false) {
                Scaffold()
            }
        }
    }
}