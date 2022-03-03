package com.dropbox.componentbox.samples.discovery

import app.cash.zipline.Zipline
import kotlinx.serialization.ExperimentalSerializationApi

private val zipline by lazy { Zipline.get() }

@OptIn(ExperimentalSerializationApi::class)
@JsExport
fun preparePresenters() {
    val hostApi = zipline.take<HostApi>(name = "hostApi")
    val presenter: DiscoveryPresenter = RealDiscoveryPresenter(hostApi)
    zipline.bind("discoveryPresenter", presenter)
}