package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.component.Column
import com.dropbox.componentbox.component.Text
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class RealCampaignsComponentBoxModel(private val componentBoxUrls: Flow<String?>) : CampaignsComponentBoxModel {

    private val stateFlow = MutableStateFlow(CampaignsComponentBoxState())
    private val componentBoxFlow = MutableStateFlow<ComponentBox?>(null)
    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    override fun present(events: Flow<CampaignsComponentBoxEvent>): StateFlow<CampaignsComponentBoxState> = stateFlow
        .also { launchComponentBox() }
        .also { componentBoxFlow.subscribe() }
        .also { events.subscribe() }

    private fun onEvent(event: CampaignsComponentBoxEvent?) {
        when (event) {
            CampaignsComponentBoxEvent.Dismiss -> {
                componentBoxFlow.value = null
            }

            null -> {}
        }
    }

    private fun launchComponentBox() = coroutineScope.launch {
        componentBoxUrls.filterNotNull().collect { componentBoxUrl ->
            val componentBox = fetchComponentBox(componentBoxUrl)
            componentBoxFlow.value = componentBox
        }
    }

    private suspend fun fetchComponentBox(componentBoxUrl: String): ComponentBox {
        val componentBox = Column.of(
            components = mutableListOf(
                Text.of(text = "Component Box")
            )
        )

        return ComponentBox.of(componentBox)
    }

    private fun MutableStateFlow<ComponentBox?>.subscribe() =
        coroutineScope.launch { collect { componentBox -> stateFlow.value = CampaignsComponentBoxState(componentBox) } }

    private fun Flow<CampaignsComponentBoxEvent?>.subscribe() =
        coroutineScope.launch { collect { event -> onEvent(event) } }
}