package com.dropbox.componentbox.discovery.zipline

import app.cash.zipline.Zipline
import com.dropbox.componentbox.models.ComponentBox
import com.dropbox.componentbox.models.ComponentBoxType
import kotlinx.serialization.ExperimentalSerializationApi

private val zipline by lazy { Zipline.get() }

@OptIn(ExperimentalSerializationApi::class)
@JsExport
fun loadComponentBox() {
    val hostApi = zipline.take<HostApi>(name = "hostApi")
    val loader = ComponentBoxLoader(hostApi)

    ComponentBoxType.values().forEach { type ->
        when (type) {
            ComponentBoxType.Screen -> loader.run<ComponentBox.Screen>(type)
            ComponentBoxType.Modal -> loader.run<ComponentBox.Modal>(type)
            ComponentBoxType.Banner -> loader.run<ComponentBox.Banner>(type)
        }
    }
}

private class ComponentBoxLoader(private val hostApi: HostApi) {
    fun <C : ComponentBox> run(type: ComponentBoxType) {
        val presenter = createPresenter<C>()
        bindPresenter(type.presenterName(), presenter)
    }

    private fun <C : ComponentBox> createPresenter() = RealComponentBoxPresenter<C>(hostApi)
    private fun <C : ComponentBox> bindPresenter(name: String, presenter: ComponentBoxPresenter<C>) {
        zipline.bind(name, presenter)
    }
}
