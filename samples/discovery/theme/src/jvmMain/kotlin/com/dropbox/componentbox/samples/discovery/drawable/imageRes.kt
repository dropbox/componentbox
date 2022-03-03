package com.dropbox.componentbox.samples.discovery.drawable

import com.dropbox.componentbox.models.MultiplatformRes

actual fun String?.imageRes(): MultiplatformRes {
    val images = DiscoveryImages()

    if (this == null) return images.placeholder.light

    val split = this.split(".")
    val name = split[0]
    val type = split[1]

    val image = images.get(name)
    val imageType = type.imageType()
    return image.use(imageType)
}