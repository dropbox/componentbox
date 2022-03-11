package com.dropbox.componentbox.discovery.discovery

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.dropbox.componentbox.foundation.Themer

class DiscoveryThemer : Themer() {
    @Composable
    override fun Theme(isNightMode: Boolean, content: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun toColor(name: String?): Color {
        TODO("Not yet implemented")
    }

    @Composable
    override fun getDrawableResId(name: String?): Int? {
        TODO("Not yet implemented")
    }

    @Composable
    override fun getColorResId(name: String?): Int? {
        TODO("Not yet implemented")
    }

    @Composable
    override fun getTextStyle(name: String?): TextStyle {
        TODO("Not yet implemented")
    }
}