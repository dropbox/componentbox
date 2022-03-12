@file:Suppress("UNCHECKED_CAST")

package com.dropbox.componentbox.presentation

import com.airbnb.mvrx.MavericksViewModel
import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.foundation.ComponentBoxType
import com.dropbox.componentbox.zipline.ComponentBoxZipline
import kotlinx.coroutines.flow.MutableStateFlow

abstract class ComponentBoxPresenter<C : ComponentBox, S : ComponentBoxState, V : ComponentBoxViewModel<C>>(
    initialState: S,
    viewModel: V,
    val zipline: ComponentBoxZipline,
    type: ComponentBoxType,
    componentBoxUrl: String
) : MavericksViewModel<S>(initialState) {
    val models = MutableStateFlow(viewModel)

    init {
        when (type) {
            ComponentBoxType.Screen -> zipline.produceModelsIn(
                componentBoxUrl,
                viewModelScope,
                models as MutableStateFlow<ComponentBoxViewModel<ComponentBox.Screen>>
            )
            ComponentBoxType.Modal -> zipline.produceModelsIn(
                componentBoxUrl,
                viewModelScope,
                models as MutableStateFlow<ComponentBoxViewModel<ComponentBox.Modal>>
            )
            ComponentBoxType.Banner -> zipline.produceModelsIn(
                componentBoxUrl,
                viewModelScope,
                models as MutableStateFlow<ComponentBoxViewModel<ComponentBox.Banner>>
            )
        }
    }

    inline fun <reified C : ComponentBox> load(componentBoxUrl: String) {
        if (isLoading()) return

        when (C::class) {
            ComponentBox.Banner::class -> zipline.produceModelsIn(
                componentBoxUrl,
                viewModelScope,
                models as MutableStateFlow<ComponentBoxViewModel<ComponentBox.Banner>>
            )
            ComponentBox.Modal::class -> zipline.produceModelsIn(
                componentBoxUrl,
                viewModelScope,
                models as MutableStateFlow<ComponentBoxViewModel<ComponentBox.Modal>>
            )
            ComponentBox.Screen::class -> zipline.produceModelsIn(
                componentBoxUrl,
                viewModelScope,
                models as MutableStateFlow<ComponentBoxViewModel<ComponentBox.Screen>>
            )
        }

        setState(RealComponentBoxState(ComponentBoxViewState.Loading))
    }

    fun setState(nextState: ComponentBoxState) {
        setState {
            nextState as S
        }
    }

    fun isLoading(): Boolean {
        var isLoading = true
        withState { state ->
            isLoading = state.viewState is ComponentBoxViewState.Loading
        }
        return isLoading
    }

    private fun MutableStateFlow<V>.isInitialized() = this.value.root != null
}



