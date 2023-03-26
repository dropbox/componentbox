package com.dropbox.componentbox.model

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.Component

@Composable
inline fun <reified Model : ComposableModel<*, *>>
        StatefulComposable(creator: (model: Model) -> Component): Component = creator(composableModel())
