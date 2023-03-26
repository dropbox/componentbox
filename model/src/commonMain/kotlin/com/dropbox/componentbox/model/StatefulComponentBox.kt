package com.dropbox.componentbox.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.dropbox.componentbox.ComponentBox
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun StatefulComponentBox(default: ComponentBox, creator: @Composable () -> ComponentBox.Dynamic): StateFlow<ComponentBox> {

    val modelProvider = remember { ComposableModelProvider() }

    val stateFlow: MutableStateFlow<ComponentBox> = MutableStateFlow(default)
    val componentBox: StateFlow<ComponentBox> = stateFlow

    CompositionLocalProvider(LocalComposableModelProvider provides modelProvider) {
        stateFlow.value = creator()
    }

    return componentBox
}