@file:Suppress("UNCHECKED_CAST")

package com.dropbox.componentbox.samples.discovery

import com.dropbox.componentbox.models.ComponentBox
import com.dropbox.componentbox.models.ComponentBoxType
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.serialization.json.Json

class RealComponentBoxPresenter<C : ComponentBox>(
    private val hostApi: HostApi
) : ComponentBoxPresenter<C> {
    private var componentBox: C? = null

    override suspend fun produceModels(id: String, type: ComponentBoxType?): Flow<ComponentBoxViewModel<C>> {
        return coroutineScope {
            channelFlow {
                loadComponentBox(id, type)
                send(produceModel())
            }
        }
    }

    private suspend fun loadComponentBox(id: String, type: ComponentBoxType?) {
        val endpoint = when (type) {
            ComponentBoxType.Screen -> "screens"
            ComponentBoxType.Modal -> "modals"
            ComponentBoxType.Banner -> "banners"
            else -> "fallbacks"
        }

        val url = "$ROOT_API_URL/$API_VERSION/$endpoint/$id"
        val headers = mapOf<String, String>()

        val response = hostApi.httpCall(url = url, headers = headers)
        componentBox = Json.decodeFromString(ComponentBox.serializer(), response) as C
    }

    private fun produceModel(): ComponentBoxViewModel<C> {
        return ComponentBoxViewModel(componentBox!!)
    }
}

private const val ROOT_API_URL = "https://api.componentbox.io"
private const val API_VERSION = "0.0.1-alpha"
