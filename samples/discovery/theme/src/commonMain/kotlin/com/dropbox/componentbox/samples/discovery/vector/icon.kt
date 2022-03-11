package com.dropbox.componentbox.samples.discovery.vector

import com.dropbox.componentbox.foundation.Icon
import com.dropbox.componentbox.foundation.IconType

fun DiscoveryIcons.get(name: String?) = when (name) {
    "CheckmarkCircle" -> checkmarkCircle
    "Fail" -> fail
    "Twinkle2" -> twinkle2
    else -> fail
}

fun Icon.use(type: IconType) = when (type) {
    IconType.Line -> this.line
    IconType.Fill -> this.fill ?: this.line
    IconType.Pictogram -> this.pictogram ?: this.line
    IconType.Spot -> this.spot ?: this.line
}

fun String?.iconType(): IconType = when (this) {
    "Line" -> IconType.Line
    "Fill" -> IconType.Fill
    "Pictogram" -> IconType.Pictogram
    "Spot" -> IconType.Spot
    else -> IconType.Line
}