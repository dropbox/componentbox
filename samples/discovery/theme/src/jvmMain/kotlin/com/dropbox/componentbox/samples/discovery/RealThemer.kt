package com.dropbox.componentbox.samples.discovery

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.dropbox.componentbox.foundation.Themer
import com.dropbox.componentbox.samples.discovery.drawable.DiscoveryImages
import com.dropbox.componentbox.samples.discovery.drawable.get
import com.dropbox.componentbox.util.translate

class RealThemer : Themer() {
    @Composable
    override fun Theme(isNightMode: Boolean, content: @Composable () -> Unit) {
        discoveryTheme(isNightMode, content)
    }

    @Composable
    override fun getDrawableResPath(name: String?): String? {
        if (name == null) return null

        val image = DiscoveryImages().get(name)
        return if (isSystemInDarkTheme() || !MaterialTheme.colors.isLight) image.dark.resPath else image.light.resPath
    }

    @Composable
    override fun getTextStyle(name: String?): TextStyle? {
        return name.translate<TextStyle>()
    }
}