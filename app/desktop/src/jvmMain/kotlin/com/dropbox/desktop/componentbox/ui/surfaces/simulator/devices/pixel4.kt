package com.dropbox.desktop.componentbox.ui.surfaces.simulator.devices

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dropbox.desktop.componentbox.store.store
import com.dropbox.desktop.componentbox.store.subscriptions.syncNightMode

@Composable
fun pixel4(content: @Composable () -> Unit) {

    val background = remember { mutableStateOf(store.state.themeState.background) }
    val isNightMode = remember { mutableStateOf(store.state.screenState.isNightMode) }

    fun subscribe() {
        syncNightMode(isNightMode, store.state)
        background.value = store.state.themeState.background
    }

    store.subscribe { subscribe() }

    Box(modifier = Modifier.height(800.dp).width(400.dp), contentAlignment = Alignment.TopCenter) {
        Column(
            modifier = Modifier.height(800.dp)
                .padding(top = 45.dp, start = 35.dp, bottom = 55.dp, end = 35.dp)
                .background(color = if (isNightMode.value) Color(background.value.dark) else Color(background.value.light)),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = Modifier.fillMaxWidth().height(50.dp)
                    .background(color = if (isNightMode.value) Color(background.value.dark) else Color(background.value.light)),
            ) {}

            Row(modifier = Modifier.fillMaxWidth().height(30.dp).background(color = Color.Black)) {}

        }

        content()

        Image(
            painter = painterResource("drawable/pixel_4.webp"),
            contentDescription = null,
            modifier = Modifier.height(800.dp).offset(y = 0.dp)
        )
    }
}