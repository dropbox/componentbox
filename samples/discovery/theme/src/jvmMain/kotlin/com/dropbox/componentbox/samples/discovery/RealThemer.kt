package com.dropbox.componentbox.samples.discovery

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.Themer
import com.dropbox.componentbox.samples.discovery.color.*
import com.dropbox.componentbox.samples.discovery.drawable.DiscoveryImages
import com.dropbox.componentbox.samples.discovery.drawable.get
import com.dropbox.componentbox.util.translate

class RealThemer : Themer() {
    @Composable
    override fun Theme(isNightMode: Boolean, content: @Composable () -> Unit) {
        discoveryTheme(isNightMode, content)
    }

    @Composable
    override fun toMaterialTheme(color: Color) = when (color) {
        DiscoveryColors.primary -> MaterialTheme.colors.primary
        DiscoveryColors.primaryVariant -> MaterialTheme.colors.primaryVariant
        DiscoveryColors.secondary -> MaterialTheme.colors.secondary
        DiscoveryColors.secondaryVariant -> MaterialTheme.colors.secondaryVariant
        DiscoveryColors.background -> MaterialTheme.colors.background
        DiscoveryColors.surface -> MaterialTheme.colors.surface
        DiscoveryColors.error -> MaterialTheme.colors.error
        DiscoveryColors.onPrimary -> MaterialTheme.colors.onPrimary
        DiscoveryColors.onSecondary -> MaterialTheme.colors.onSecondary
        DiscoveryColors.onBackground -> MaterialTheme.colors.onBackground
        DiscoveryColors.onSurface -> MaterialTheme.colors.onSurface
        DiscoveryColors.onError -> MaterialTheme.colors.onError
        DiscoveryColors.disabledBackground -> MaterialTheme.colors.disabledBackground
        DiscoveryColors.standardBackgroundElevated -> MaterialTheme.colors.standardBackgroundElevated
        DiscoveryColors.successFill -> MaterialTheme.colors.successFill
        DiscoveryColors.faintText -> MaterialTheme.colors.faintText
        DiscoveryColors.standardText -> MaterialTheme.colors.standardText
        else -> MaterialTheme.colors.standardText
    }

    @Composable
    override fun toColor(name: String?) = when (name) {
        DiscoveryColors.primary.title -> MaterialTheme.colors.primary
        DiscoveryColors.primaryVariant.title -> MaterialTheme.colors.primaryVariant
        DiscoveryColors.secondary.title -> MaterialTheme.colors.secondary
        DiscoveryColors.secondaryVariant.title -> MaterialTheme.colors.secondaryVariant
        DiscoveryColors.background.title -> MaterialTheme.colors.background
        DiscoveryColors.surface.title -> MaterialTheme.colors.surface
        DiscoveryColors.error.title -> MaterialTheme.colors.error
        DiscoveryColors.onPrimary.title -> MaterialTheme.colors.onPrimary
        DiscoveryColors.onSecondary.title -> MaterialTheme.colors.onSecondary
        DiscoveryColors.onBackground.title -> MaterialTheme.colors.onBackground
        DiscoveryColors.onSurface.title -> MaterialTheme.colors.onSurface
        DiscoveryColors.onError.title -> MaterialTheme.colors.onError
        DiscoveryColors.disabledBackground.title -> MaterialTheme.colors.disabledBackground
        DiscoveryColors.standardBackgroundElevated.title -> MaterialTheme.colors.standardBackgroundElevated
        DiscoveryColors.successFill.title -> MaterialTheme.colors.successFill
        DiscoveryColors.faintText.title -> MaterialTheme.colors.faintText
        DiscoveryColors.standardText.title -> MaterialTheme.colors.standardText
        else -> MaterialTheme.colors.standardText
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