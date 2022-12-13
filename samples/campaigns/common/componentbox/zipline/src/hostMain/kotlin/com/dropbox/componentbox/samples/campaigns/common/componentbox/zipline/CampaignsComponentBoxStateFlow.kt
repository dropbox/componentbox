package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import app.cash.zipline.Zipline
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow

@Suppress("FunctionName")
fun CampaignsComponentBoxStateFlow(
    initialState: CampaignsComponentBoxState,
    ziplineMetadataFetcher: suspend () -> ZiplineMetadata,
    ziplineInitializer: (Zipline) -> Unit,
    events: Flow<CampaignsComponentBoxEvent> = flow { },
    coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default,
    coroutineScope: CoroutineScope = CoroutineScope(coroutineDispatcher),
    loadingState: CampaignsComponentBoxState? = null,
): StateFlow<CampaignsComponentBoxState> = RealCampaignsComponentBoxStateFlow(
    initialState = initialState,
    ziplineMetadataFetcher = ziplineMetadataFetcher,
    ziplineInitializer = ziplineInitializer,
    coroutineScope = coroutineScope,
    loadingState = loadingState
).launch(events)