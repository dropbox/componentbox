@file:Suppress("UNCHECKED_CAST")

package com.dropbox.componentbox.discovery.zipline

import com.dropbox.componentbox.models.ComponentBox
import com.dropbox.componentbox.models.ComponentBoxType
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class RealComponentBoxPresenter<C : ComponentBox>(
    private val hostApi: HostApi
) : ComponentBoxPresenter<C> {

    override suspend fun produceModels(id: String, type: ComponentBoxType?): Flow<ComponentBoxViewModel<C>> {
        return coroutineScope {
            channelFlow {
                send(loadComponentBox(id, type))
            }
        }
    }

    private suspend fun loadComponentBox(id: String, type: ComponentBoxType?): ComponentBoxViewModel<C> {
        val endpoint = when (type) {
            ComponentBoxType.Screen -> "screens"
            ComponentBoxType.Modal -> "modals"
            ComponentBoxType.Banner -> "banners"
            else -> "fallbacks"
        }

        val url = "$ROOT_API_URL/$endpoint/$id"
        println("API URL, $url")
        val headers = mapOf<String, String>()

        val response = hostApi.httpCall(url = url, headers = headers)
        println("Response, $response")
        val c = Json.decodeFromString<ComponentBox>(response)
        println("Component Box, $c")
        return ComponentBoxViewModel(c as C)
    }
}

private const val ROOT_API_URL = "https://api.componentbox.io"
private const val API_VERSION = "0.0.1-alpha"
