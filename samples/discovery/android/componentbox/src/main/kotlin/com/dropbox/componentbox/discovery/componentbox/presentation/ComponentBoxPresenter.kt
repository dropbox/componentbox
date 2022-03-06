package com.dropbox.componentbox.discovery.componentbox.presentation

import com.airbnb.mvrx.MavericksViewModel
import com.dropbox.componentbox.models.ComponentBox
import com.dropbox.componentbox.samples.discovery.ComponentBoxViewModel
import com.dropbox.componentbox.samples.discovery.ComponentBoxZipline
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow

class ComponentBoxPresenter(
    initialState: ComponentBoxState,
    val zipline: ComponentBoxZipline,
) : MavericksViewModel<ComponentBoxState>(initialState) {

    inline fun <reified C : ComponentBox> load(id: String) {
        val models = MutableStateFlow(ComponentBoxViewModel<C>())
        val scope = MainScope()
        zipline.load(id, scope, models)
    }
}
