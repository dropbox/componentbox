package com.dropbox.componentbox.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dropbox.componentbox.android.preview.DiscoveryTheme
import com.dropbox.componentbox.android.preview.PreviewScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComponentBoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiscoveryTheme(isNightMode = false) {
                PreviewScreen()
            }
        }
    }
}