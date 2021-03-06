package com.dropbox.componentbox.samples.discovery.drawable

import com.dropbox.componentbox.foundation.MultiplatformRes

actual fun String?.imageRes(): MultiplatformRes {
    val images = DiscoveryImages()

    if (this == null) return images.placeholder

    return images.get(this)
}


