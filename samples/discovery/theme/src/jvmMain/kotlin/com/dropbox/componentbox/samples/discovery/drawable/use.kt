package com.dropbox.componentbox.samples.discovery.drawable

import com.dropbox.componentbox.foundation.Image
import com.dropbox.componentbox.foundation.ImageType
import com.dropbox.componentbox.foundation.MultiplatformRes

actual fun Image.use(type: ImageType): MultiplatformRes = when (type) {
    ImageType.Light -> this.light
    ImageType.Dark -> this.dark
}

actual fun discoveryImages(): DiscoveryImages = DiscoveryImages()