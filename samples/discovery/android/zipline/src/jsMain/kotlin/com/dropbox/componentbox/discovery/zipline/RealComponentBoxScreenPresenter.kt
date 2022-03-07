package com.dropbox.componentbox.discovery.zipline

import com.dropbox.componentbox.models.ComponentBox
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class RealComponentBoxScreenPresenter(
    private val hostApi: HostApi
) : ComponentBoxScreenPresenter {

    override suspend fun produceModels(id: String): Flow<ComponentBoxScreenViewModel> {
        return coroutineScope {
            channelFlow {
                send(loadComponentBox(id))
            }
        }
    }

    private suspend fun loadComponentBox(id: String): ComponentBoxScreenViewModel {
        val url = "$ROOT_API_URL/$ENDPOINT/$id"
        val headers = mapOf<String, String>()

        val response = hostApi.httpCall(url = url, headers = headers)
        val screen = Json.decodeFromString<ComponentBox.Screen>(response)
        return ComponentBoxScreenViewModel(screen)
    }

    companion object {
        private const val ROOT_API_URL = "https://api.componentbox.io"
        private const val API_VERSION = "0.0.1-alpha"
        private const val ENDPOINT = "screens"
    }
}