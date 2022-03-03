package com.dropbox.componentbox.samples.discovery

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.Themer
import com.dropbox.componentbox.models.Color
import com.dropbox.componentbox.samples.discovery.color.DiscoveryColors
import com.dropbox.componentbox.samples.discovery.color.disabledBackground
import com.dropbox.componentbox.samples.discovery.color.faintText
import com.dropbox.componentbox.samples.discovery.color.standardBackgroundElevated
import com.dropbox.componentbox.samples.discovery.color.standardText
import com.dropbox.componentbox.samples.discovery.color.successFill

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
}