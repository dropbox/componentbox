package com.dropbox.desktop.componentbox.ui.surfaces.simulator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.dropbox.componentbox.foundation.Inflater
import com.dropbox.componentbox.foundation.Component
import com.dropbox.desktop.componentbox.store.store
import com.dropbox.desktop.componentbox.store.subscriptions.syncComponents
import com.dropbox.desktop.componentbox.store.subscriptions.syncScreenHorizontalAlignment
import com.dropbox.desktop.componentbox.store.subscriptions.syncScreenVerticalArrangement
import com.dropbox.desktop.componentbox.util.copy
import com.dropbox.desktop.componentbox.util.horizontal
import com.dropbox.desktop.componentbox.util.inflate
import com.dropbox.desktop.componentbox.util.vertical

@Composable
fun content(inflater: Inflater, height: Dp) {
    val screenVerticalArrangement = remember { mutableStateOf(store.state.screenState.verticalArrangement) }
    val screenHorizontalAlignment = remember { mutableStateOf(store.state.screenState.horizontalAlignment) }
    val components = remember { mutableStateListOf<Component>() }

    fun subscribe() {
        syncScreenVerticalArrangement(screenVerticalArrangement, store.state)
        syncScreenHorizontalAlignment(screenHorizontalAlignment, store.state)
        syncComponents(components, store.state)
    }

    store.subscribe { subscribe() }

    Column(
        modifier = Modifier.height(height),
        verticalArrangement = screenVerticalArrangement.value.vertical(),
        horizontalAlignment = screenHorizontalAlignment.value.horizontal()
    ) {

        components.toMutableStateList().forEach { component ->
            val copy = component.copy()
            copy.inflate(inflater)
        }
    }
}