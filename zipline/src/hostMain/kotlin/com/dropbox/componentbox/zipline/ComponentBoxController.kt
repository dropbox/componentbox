package com.dropbox.componentbox.zipline

import app.cash.zipline.Zipline
import com.dropbox.componentbox.foundation.ComponentBoxEvent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow

expect class ComponentBoxController {
    inline fun <reified Service : ComponentBoxService<Model, State, Event>, Model : ComponentBoxModel<State, Event>, State : ComponentBoxState, Event : ComponentBoxEvent> model(
        noinline ziplineInitializer: (Zipline) -> Unit = {}
    ): StateFlow<Model?>
}

expect fun componentBoxController(
    ziplineMetadata: ZiplineMetadata,
    dispatcher: CoroutineDispatcher = Dispatchers.Default,
    coroutineScope: CoroutineScope = CoroutineScope(dispatcher)
): ComponentBoxController