package com.dropbox.componentbox.samples.discovery.drawable

import com.dropbox.componentbox.foundation.Image
import com.dropbox.componentbox.foundation.Images
import com.dropbox.componentbox.foundation.RealImage
import com.dropbox.componentbox.foundation.RealMultiplatformRes

actual class DiscoveryImages : Images {

    actual val placeholder: Image = RealImage(
        name = "Placeholder",
        light = RealMultiplatformRes("Placeholder.Light", "drawable-xhdpi/placeholder.webp"),
        dark = RealMultiplatformRes("Placeholder.Dark", "drawable-night-xhdpi/placeholder.webp")
    )

    actual val trafficRoadBlocked: Image = RealImage(
        name = "TrafficRoadBlocked",
        light = RealMultiplatformRes("TrafficRoadBlocked.Light", "drawable-xhdpi/traffic_road_blocked.webp"),
        dark = RealMultiplatformRes("TrafficRoadBlocked.Dark", "drawable-night-xhdpi/traffic_road_blocked.webp")
    )

    override fun list(): MutableList<Image> = mutableListOf(
        placeholder,
        trafficRoadBlocked
    )
}