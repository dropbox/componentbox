package com.dropbox.componentbox.ui.surfaces.simulator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.store.subscriptions.syncNightMode
import com.dropbox.componentbox.store.subscriptions.syncScreenTitle

@Composable
fun toolbar() {
    val screenTitle = remember { mutableStateOf<String?>(null) }
    val background = remember { mutableStateOf(store.state.themeState.background) }
    val isNightMode = remember { mutableStateOf(store.state.screenState.isNightMode) }

    fun subscribe() {
        syncScreenTitle(screenTitle, store.state)
        syncNightMode(isNightMode, store.state)
        background.value = store.state.themeState.background
    }

    store.subscribe { subscribe() }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = if (isNightMode.value) Color(background.value.dark) else Color(background.value.light)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource("drawable/ic_dig_list_view_line.xml"),
            contentDescription = null,
            tint = if (isNightMode.value) Color(background.value.light) else Color(background.value.dark),
            modifier = Modifier.padding(start = 16.dp)
        )
        Text(
            text = screenTitle.value ?: "",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 18.sp
        )
    }
}