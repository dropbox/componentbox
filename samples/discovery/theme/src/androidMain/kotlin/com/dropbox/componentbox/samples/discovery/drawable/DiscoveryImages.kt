package com.dropbox.componentbox.samples.discovery.drawable

import com.dropbox.componentbox.discovery.theme.R
import com.dropbox.componentbox.models.Image
import com.dropbox.componentbox.models.Images
import com.dropbox.componentbox.models.RealImage

actual class DiscoveryImages : Images {
    actual val placeholder: Image = RealImage("Placeholder", R.drawable.placeholder)
    actual val trafficRoadBlocked: Image = RealImage("TrafficRoadBlocked", R.drawable.traffic_road_blocked)

    override fun list(): MutableList<Image> = mutableListOf(
        placeholder,
        trafficRoadBlocked
    )
}