package com.dropbox.componentbox.samples.discovery

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.ResourceProvider
import com.dropbox.componentbox.models.Colors
import com.dropbox.componentbox.models.Images
import com.dropbox.componentbox.models.Typography
import com.dropbox.componentbox.samples.discovery.color.DiscoveryColors
import com.dropbox.componentbox.samples.discovery.drawable.DiscoveryImages
import com.dropbox.componentbox.samples.discovery.type.DiscoveryTypography
import com.dropbox.componentbox.samples.discovery.vector.DiscoveryIcons

actual class RealResourceProvider : ResourceProvider {
    @Composable
    override fun icons() = DiscoveryIcons()

    @Composable
    override fun images(): Images = DiscoveryImages()

    @Composable
    override fun typography(): Typography = DiscoveryTypography

    @Composable
    override fun colors(): Colors = DiscoveryColors
}