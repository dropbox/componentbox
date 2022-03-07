package com.dropbox.componentbox.discovery.zipline

import com.dropbox.componentbox.models.ComponentBox
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class RealComponentBoxModalPresenter(
    private val hostApi: HostApi
) : ComponentBoxModalPresenter {

    override suspend fun produceModels(id: String): Flow<ComponentBoxModalViewModel> {
        return coroutineScope {
            channelFlow {
                send(loadComponentBox(id))
            }
        }
    }

    private suspend fun loadComponentBox(id: String): ComponentBoxModalViewModel {
        val url = "$ROOT_API_URL/$ENDPOINT/$id.$FILE_TYPE"
        val headers = mapOf<String, String>()

        val response = hostApi.httpCall(url = url, headers = headers)
        val modal = Json.decodeFromString<ComponentBox.Modal>(response)
        return ComponentBoxModalViewModel(modal)
    }

    companion object {
        private const val ROOT_API_URL = "https://api.componentbox.io"
        private const val API_VERSION = "0.0.1-alpha"
        private const val ENDPOINT = "modals"
        private const val FILE_TYPE = "json"
    }
}

