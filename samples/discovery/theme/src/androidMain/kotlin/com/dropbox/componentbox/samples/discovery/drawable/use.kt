package com.dropbox.componentbox.samples.discovery.drawable

import com.dropbox.componentbox.models.Image
import com.dropbox.componentbox.models.ImageType
import com.dropbox.componentbox.models.MultiplatformRes

actual fun Image.use(type: ImageType): MultiplatformRes = this

actual fun discoveryImages(): DiscoveryImages = DiscoveryImages()