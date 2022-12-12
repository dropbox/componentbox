package com.dropbox.componentbox.model

import app.cash.zipline.Zipline
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow

expect class ComponentBoxController {
    inline fun <reified Service : ComponentBoxService<Model, State>, Model : ComponentBoxModel<State>, State : ComponentBoxState> model(
        noinline initializer: (Zipline) -> Unit = {}
    ): StateFlow<Model?>
}

expect fun componentBoxController(
    serviceCoordinates: ServiceCoordinates,
    dispatcher: CoroutineDispatcher = Dispatchers.Default,
    coroutineScope: CoroutineScope = CoroutineScope(dispatcher)
): ComponentBoxController