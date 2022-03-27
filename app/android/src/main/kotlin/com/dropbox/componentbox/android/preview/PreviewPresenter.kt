package com.dropbox.componentbox.android.preview

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.dropbox.componentbox.foundation.ComponentBox
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.serialization.kotlinx.KotlinxWebsocketSerializationConverter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.serialization.json.Json

class PreviewPresenter(initialState: PreviewState) : MavericksViewModel<PreviewState>(initialState) {
    val screen: MutableStateFlow<ComponentBox.Screen?> = MutableStateFlow(null)
    val isRefreshing = MutableStateFlow(false)

    private val client = HttpClient(CIO) {
        install(WebSockets) {
            contentConverter = KotlinxWebsocketSerializationConverter(Json)
            pingInterval = 500
        }
    }
    private val api = PreviewApi(client)
    private val webSocketApi = WebSocketApi(client, screen)

    fun subscribe() {
        webSocketApi.subscribe()
    }

    suspend fun pull() {
        isRefreshing.value = true
        screen.value = api.pull("http://10.0.2.2:8080")
        isRefreshing.value = false
    }

    // suspend fun load() {
    //
    //     val response = api.httpCall("http://10.0.2.2:8080/static/componentbox.json", mapOf())
    //     val root: ComponentBox.Screen = Json.decodeFromString(response)
    //     screen.value = root
    // }

    companion object : MavericksViewModelFactory<PreviewPresenter, PreviewState> {
        override fun initialState(viewModelContext: ViewModelContext): PreviewState {
            return PreviewState(PreviewViewState.Initialized)
        }

        override fun create(viewModelContext: ViewModelContext, state: PreviewState): PreviewPresenter {
            return PreviewPresenter(PreviewState(PreviewViewState.Initialized))
        }
    }
}

data class PreviewState(
    val viewState: PreviewViewState
) : MavericksState

sealed class PreviewViewState {
    object Initialized : PreviewViewState()
    object Loading : PreviewViewState()
    object Failure : PreviewViewState()
    object Success : PreviewViewState()
}