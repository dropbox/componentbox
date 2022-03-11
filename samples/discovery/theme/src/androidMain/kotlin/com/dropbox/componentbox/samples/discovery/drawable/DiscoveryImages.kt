package com.dropbox.componentbox.samples.discovery.drawable

import com.dropbox.componentbox.discovery.theme.R
import com.dropbox.componentbox.foundation.Image
import com.dropbox.componentbox.foundation.Images
import com.dropbox.componentbox.foundation.RealImage

actual class DiscoveryImages : Images {
    actual val placeholder: Image = RealImage("Placeholder", R.drawable.placeholder)
    actual val trafficRoadBlocked: Image = RealImage("TrafficRoadBlocked", R.drawable.traffic_road_blocked)

    override fun list(): MutableList<Image> = mutableListOf(
        placeholder,
        trafficRoadBlocked
    )
}