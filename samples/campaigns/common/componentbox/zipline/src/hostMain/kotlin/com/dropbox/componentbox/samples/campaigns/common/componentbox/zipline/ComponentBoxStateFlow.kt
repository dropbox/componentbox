package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import app.cash.zipline.Zipline
import com.dropbox.componentbox.foundation.ComponentBoxEvent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow

@Suppress("FunctionName")
inline fun <reified Service : ComponentBoxService<Model, State, Event>, Model : ComponentBoxModel<State, Event>, State : ComponentBoxState, Event : ComponentBoxEvent> ComponentBoxStateFlow(
    initialState: State,
    noinline ziplineMetadataFetcher: suspend () -> ZiplineMetadata,
    noinline ziplineInitializer: (zipline: Zipline) -> Unit,
    events: Flow<Event> = flow { },
    coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default,
    coroutineScope: CoroutineScope = CoroutineScope(coroutineDispatcher),
    loadingState: State? = null,
): StateFlow<State> = RealComponentBoxStateFlow<Model, State, Event>(
    initialState = initialState,
    ziplineMetadataFetcher = ziplineMetadataFetcher,
    ziplineInitializer = ziplineInitializer,
    coroutineScope = coroutineScope,
    loadingState = loadingState
).launch<Service>(events)