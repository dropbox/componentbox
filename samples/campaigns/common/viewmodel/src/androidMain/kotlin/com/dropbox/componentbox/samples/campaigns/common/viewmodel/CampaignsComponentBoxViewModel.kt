package com.dropbox.componentbox.samples.campaigns.common.viewmodel

import app.cash.zipline.Zipline
import com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline.CampaignsComponentBoxEvent
import com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline.CampaignsComponentBoxState
import com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline.CampaignsComponentBoxStateFlow
import com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline.ZiplineMetadata
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

actual abstract class CampaignsComponentBoxViewModel(
    private val initialState: CampaignsComponentBoxState,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val coroutineScope: CoroutineScope = CoroutineScope(coroutineDispatcher)
) : ViewModel<CampaignsComponentBoxState, CampaignsComponentBoxEvent>(initialState) {
    protected abstract suspend fun ziplineMetadataFetcher(): ZiplineMetadata
    protected abstract fun ziplineInitializer(zipline: Zipline)

    protected abstract val events: Flow<CampaignsComponentBoxEvent>

    protected open val loadingState: CampaignsComponentBoxState? = null

    private val componentBoxStateFlow: StateFlow<CampaignsComponentBoxState> by lazy {
        CampaignsComponentBoxStateFlow(
            initialState = initialState,
            ziplineMetadataFetcher = ::ziplineMetadataFetcher,
            ziplineInitializer = ::ziplineInitializer,
            events = events,
            coroutineDispatcher = coroutineDispatcher,
            coroutineScope = coroutineScope,
            loadingState = loadingState
        )
    }

    fun present() {
        coroutineScope.launch { componentBoxStateFlow.collect { state -> setState(state) } }
    }
}