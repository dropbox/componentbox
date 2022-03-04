package com.dropbox.componentbox.samples.discovery

import com.dropbox.componentbox.models.ComponentBox
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class RealDiscoveryPresenter(
    private val hostApi: HostApi
) : DiscoveryPresenter {
    private lateinit var screen: ComponentBox.Screen

    override suspend fun produceModels(): Flow<DiscoveryScreenViewModel> {
        return coroutineScope {
            channelFlow {
                loadComponentIndex()
                send(produceModel())
            }
        }
    }

    private suspend fun loadComponentIndex() {
        val json = hostApi.httpCall(url = "https://api.componentbox.io/screens/1", headers = mapOf())
        screen = Json.decodeFromString(json)
    }

    private fun produceModel(): DiscoveryScreenViewModel {
        return DiscoveryScreenViewModel(screen)
    }
}
