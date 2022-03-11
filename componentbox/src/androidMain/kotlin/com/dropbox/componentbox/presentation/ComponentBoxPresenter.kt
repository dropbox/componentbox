@file:Suppress("UNCHECKED_CAST")

package com.dropbox.componentbox.presentation

import com.airbnb.mvrx.MavericksViewModel
import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.zipline.ComponentBoxZipline
import kotlinx.coroutines.flow.MutableStateFlow

abstract class ComponentBoxPresenter<C : ComponentBox, S : ComponentBoxState, V : ComponentBoxViewModel<C>>(
    initialState: S,
    viewModel: V,
    val zipline: ComponentBoxZipline
) : MavericksViewModel<S>(initialState) {
    val models = MutableStateFlow(viewModel)
    inline fun <reified C : ComponentBox> load(componentBoxUrl: String) {
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
    }
}



