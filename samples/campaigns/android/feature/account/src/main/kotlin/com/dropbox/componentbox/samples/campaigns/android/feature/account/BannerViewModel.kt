package com.dropbox.componentbox.samples.campaigns.android.feature.account

import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.foundation.ComponentBoxEvent
import com.dropbox.componentbox.samples.campaigns.common.viewmodel.ComponentBoxViewModel
import com.dropbox.componentbox.zipline.ComponentBoxState
import com.dropbox.componentbox.zipline.ZiplineMetadata


data class ComponentBoxBannerState(
    val componentBox: ComponentBox? = null
) : ComponentBoxState

sealed class ComponentBoxBannerEvent : ComponentBoxEvent {
    object Dismiss : ComponentBoxBannerEvent()
}

class ComponentBoxBannerViewModel(initialState: ComponentBoxBannerState = ComponentBoxBannerState()) :

    ComponentBoxViewModel<ComponentBoxBannerState, ComponentBoxBannerEvent>(initialState) {
    override fun onEvent(event: ComponentBoxBannerEvent) {
        TODO("Not yet implemented")
    }

    override suspend fun fetchZiplineMetadata(): ZiplineMetadata {
        TODO("Not yet implemented")
    }

    init {
        val componentBoxStateFlow = componentBoxStateFlowOf<>(initialState)
    }

}