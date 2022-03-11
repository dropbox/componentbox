@file:Suppress("UNCHECKED_CAST")

package com.dropbox.componentbox.zipline

import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.foundation.ComponentBoxType
import com.dropbox.componentbox.presentation.ComponentBoxViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

abstract class ComponentBoxPresenter(private val hostApi: HostApi) : ComponentBoxZiplineService {
    override suspend fun produceModelsInBanner(
        type: ComponentBoxType,
        url: String,
        headers: Map<String, String>
    ): Flow<ComponentBoxViewModel<ComponentBox.Banner>> {
        return coroutineScope {
            channelFlow {
                send(loadComponentBox<ComponentBox.Banner>(type, url, headers))
            }
        }
    }

    override suspend fun produceModelsInModal(
        type: ComponentBoxType,
        url: String,
        headers: Map<String, String>
    ): Flow<ComponentBoxViewModel<ComponentBox.Modal>> {
        return coroutineScope {
            channelFlow {
                send(loadComponentBox<ComponentBox.Modal>(type, url, headers))
            }
        }
    }

    override suspend fun produceModelsInScreen(
        type: ComponentBoxType,
        url: String,
        headers: Map<String, String>
    ): Flow<ComponentBoxViewModel<ComponentBox.Screen>> {
        return coroutineScope {
            channelFlow {
                send(loadComponentBox<ComponentBox.Screen>(type, url, headers))
            }
        }
    }

    private suspend fun <C : ComponentBox> loadComponentBox(
        type: ComponentBoxType,
        url: String,
        headers: Map<String, String> = mapOf()
    ): ComponentBoxViewModel<C> {
        val response = hostApi.httpCall(url, headers)
        val root = when (type) {
            ComponentBoxType.Banner -> Json.decodeFromString<ComponentBox.Banner>(response)
            ComponentBoxType.Modal -> Json.decodeFromString<ComponentBox.Modal>(response)
            ComponentBoxType.Screen -> Json.decodeFromString<ComponentBox.Screen>(response)
        }
        return ComponentBoxViewModel(root as C)
    }
}