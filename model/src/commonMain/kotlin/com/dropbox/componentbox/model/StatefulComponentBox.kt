package com.dropbox.componentbox.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.dropbox.componentbox.ComponentBox
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun <Output : ComponentBox?> statefulComponentBox(init: Output, creator: @Composable () -> Output): StateFlow<Output> {

    val modelProvider = remember { ComposableModelProvider() }

    val stateFlow: MutableStateFlow<Output> = MutableStateFlow(init)
    val componentBox: StateFlow<Output> = stateFlow

    CompositionLocalProvider(LocalComposableModelProvider provides modelProvider) {
        stateFlow.value = creator()
    }

    return componentBox
}