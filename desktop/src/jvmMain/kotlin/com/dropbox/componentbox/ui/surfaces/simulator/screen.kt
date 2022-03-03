package com.dropbox.componentbox.ui.surfaces.simulator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.Inflater
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.store.subscriptions.syncBottomTabs
import com.dropbox.componentbox.store.subscriptions.syncNightMode
import com.dropbox.componentbox.store.subscriptions.syncPreview
import com.dropbox.componentbox.store.subscriptions.syncScreenHeight

@Composable
fun screen(inflater: Inflater) {
    val isPreview = remember { mutableStateOf(store.state.screenState.isPreview) }
    val background = remember { mutableStateOf(store.state.themeState.background) }
    val isNightMode = remember { mutableStateOf(store.state.screenState.isNightMode) }
    val showBottomTabs = remember { mutableStateOf(store.state.screenState.showBottomTabs) }
    val screenHeight = remember { mutableStateOf(620.dp) }

    fun subscribe() {
        syncPreview(isPreview, store.state)
        syncNightMode(isNightMode, store.state)
        syncBottomTabs(showBottomTabs, store.state)
        syncScreenHeight(screenHeight, store.state)
        background.value = store.state.themeState.background
    }

    store.subscribe { subscribe() }

    Column(
        modifier = Modifier
            .height(715.dp)
            .width(330.dp)
            .padding(top = 95.dp)
            .background(color = if (isNightMode.value) Color(background.value.dark) else Color(background.value.light)),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        toolbar()

        content(inflater, screenHeight.value)

        if (showBottomTabs.value) {
            bottomNav(inflater)
        }
    }
}