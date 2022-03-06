package com.dropbox.componentbox.discovery.zipline

import com.dropbox.componentbox.models.ComponentBoxType

internal fun ComponentBoxType?.presenterName() = when (this) {
    ComponentBoxType.Screen -> "componentBoxScreenPresenter"
    ComponentBoxType.Modal -> "componentBoxModalPresenter"
    ComponentBoxType.Banner -> "componentBoxBannerPresenter"
    else -> "componentBoxFallbackPresenter"
}