package com.dropbox.componentbox.samples.discovery.drawable

import com.dropbox.componentbox.models.Image
import com.dropbox.componentbox.models.Images

expect class DiscoveryImages : Images {
    val placeholder: Image
    val trafficRoadBlocked: Image
}