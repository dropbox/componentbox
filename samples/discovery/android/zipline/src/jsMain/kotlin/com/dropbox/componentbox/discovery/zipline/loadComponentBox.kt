package com.dropbox.componentbox.discovery.zipline

import app.cash.zipline.Zipline
import com.dropbox.componentbox.models.ComponentBoxType
import kotlinx.serialization.ExperimentalSerializationApi

private val zipline by lazy { Zipline.get() }

@OptIn(ExperimentalSerializationApi::class)
@JsExport
fun loadComponentBox() {
    val hostApi = zipline.take<HostApi>(name = "hostApi")

    val bannerPresenter: ComponentBoxBannerPresenter = RealComponentBoxBannerPresenter(hostApi)
    val modalPresenter: ComponentBoxModalPresenter = RealComponentBoxModalPresenter(hostApi)
    val screenPresenter: ComponentBoxScreenPresenter = RealComponentBoxScreenPresenter(hostApi)

    zipline.bind(ComponentBoxType.Banner.presenterName(), bannerPresenter)
    zipline.bind(ComponentBoxType.Modal.presenterName(), modalPresenter)
    zipline.bind(ComponentBoxType.Screen.presenterName(), screenPresenter)
}