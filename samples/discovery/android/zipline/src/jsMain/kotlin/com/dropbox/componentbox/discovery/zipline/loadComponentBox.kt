package com.dropbox.componentbox.discovery.zipline


import app.cash.zipline.Zipline
import com.dropbox.componentbox.foundation.COMPONENT_BOX_ZIPLINE_SERVICE
import com.dropbox.componentbox.zipline.ComponentBoxZiplineService
import com.dropbox.componentbox.zipline.HostApi


private val zipline by lazy { Zipline.get() }

@JsExport
fun loadComponentBox() {
    val hostApi = zipline.take<HostApi>("hostApi")
    val componentBoxPresenter = RealComponentBoxPresenter(hostApi)
    zipline.bind<ComponentBoxZiplineService>(COMPONENT_BOX_ZIPLINE_SERVICE, componentBoxPresenter)
}