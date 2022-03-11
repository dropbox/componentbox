package com.dropbox.componentbox.samples.discovery.drawable

import com.dropbox.componentbox.foundation.Image
import com.dropbox.componentbox.foundation.ImageType
import com.dropbox.componentbox.foundation.MultiplatformRes

expect fun discoveryImages(): DiscoveryImages
expect fun Image.use(type: ImageType): MultiplatformRes

fun DiscoveryImages.get(name: String?) = when (name) {
    "TrafficRoadBlocked" -> trafficRoadBlocked
    else -> trafficRoadBlocked
}

fun String?.imageType(): ImageType = when (this) {
    "Light" -> ImageType.Light
    "Dark" -> ImageType.Dark
    else -> ImageType.Light
}

fun String?.image(): Image {
    val discoveryImages = discoveryImages()
    return discoveryImages.get(this)
}