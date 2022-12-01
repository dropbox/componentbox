package com.dropbox.componentbox.model

import app.cash.zipline.Zipline
import kotlinx.coroutines.flow.Flow

expect class ComponentBoxController<Model : ComponentBoxModel<*, State, Event>, State : ComponentBoxState, Event : ComponentBoxEvent> {
    inline fun <reified Service : ComponentBoxService<Model>> models(
        noinline initializer: (Zipline) -> Unit = {}
    ): Flow<Model>
}