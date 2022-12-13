package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import app.cash.zipline.Zipline
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RealCampaignsComponentBoxStateFlow(
    initialState: CampaignsComponentBoxState,
    private val ziplineMetadataFetcher: suspend () -> ZiplineMetadata,
    private val ziplineInitializer: (Zipline) -> Unit,
    private val coroutineScope: CoroutineScope,
    private val loadingState: CampaignsComponentBoxState? = null
) {

    private val stateFlow = MutableStateFlow(initialState)
    private val modelStateFlow = MutableStateFlow<CampaignsComponentBoxModel?>(null)

    fun launch(events: Flow<CampaignsComponentBoxEvent>): StateFlow<CampaignsComponentBoxState> =
        stateFlow.also { launchModels() }.also { subscribeToModels(events) }

    private fun launchModels() = coroutineScope.launch {
        if (loadingState != null) {
            stateFlow.value = loadingState
        }

        val metadata = ziplineMetadataFetcher.invoke()
        val controller =
            campaignsComponentBoxControllerOf(ziplineMetadata = metadata, coroutineDispatcher = Dispatchers.Default, coroutineScope = coroutineScope)
        modelStateFlow.value = controller.models(ziplineInitializer).value
    }

    private fun subscribeToModels(events: Flow<CampaignsComponentBoxEvent>) = coroutineScope.launch {
        modelStateFlow.collect { model ->
            if (model != null) {
                val state = model.present(events).value
                stateFlow.value = state
            }
        }
    }
}