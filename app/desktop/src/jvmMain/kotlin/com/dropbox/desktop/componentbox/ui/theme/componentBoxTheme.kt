package com.dropbox.desktop.componentbox.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dropbox.desktop.componentbox.store.store
import com.dropbox.desktop.componentbox.store.subscriptions.syncNightMode

@Composable
fun componentBoxTheme(content: @Composable () -> Unit) {
    val colors = remember { mutableStateOf(Colors.Dark) }
    val isNightMode = remember { mutableStateOf(store.state.screenState.isNightMode) }

    fun subscribe() {
        syncNightMode(isNightMode, store.state)
        colors.value = if (isNightMode.value) Colors.Dark else Colors.Light
    }

    store.subscribe { subscribe() }

    return MaterialTheme(
        typography = Typography,
        colors = colors.value,
        content = content
    )
}