package com.dropbox.componentbox.samples.discovery.vector

import com.dropbox.componentbox.foundation.MultiplatformRes

actual fun String?.iconRes(): MultiplatformRes {
    val icons = DiscoveryIcons()

    if (this == null) return icons.fail.line

    val split = this.split(".")
    val name = split[0]
    val type = split[1]

    val icon = icons.get(name)
    val iconType = type.iconType()
    return icon.use(iconType)
}