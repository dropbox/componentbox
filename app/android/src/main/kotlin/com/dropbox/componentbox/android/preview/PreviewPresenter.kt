package com.dropbox.componentbox.android.preview

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.dropbox.componentbox.foundation.ComponentBox
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient

class PreviewPresenter(initialState: PreviewState) : MavericksViewModel<PreviewState>(initialState) {
    val screen: MutableStateFlow<ComponentBox.Screen?> = MutableStateFlow(null)


    private val client = OkHttpClient()
    private val api = PreviewApi(client)

    suspend fun load() {

        val response = api.httpCall("http://10.0.2.2:8080/static/componentbox.json", mapOf())
        val root: ComponentBox.Screen = Json.decodeFromString(response)
        screen.value = root
    }


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