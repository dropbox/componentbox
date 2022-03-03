@file:OptIn(ExperimentalFoundationApi::class)

package com.dropbox.componentbox.ui.surfaces.inspector.panels.root

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.store.actions.ScreenAction
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.ui.theme.buttonBackground
import com.dropbox.componentbox.ui.theme.disabledBackground

@Composable
fun title() {
    val title = remember { mutableStateOf(store.state.screenState.title) }

    fun setTitle(value: String) {
        title.value = value
        store.dispatch(ScreenAction.SetTitle(value))
    }

    LazyVerticalGrid(cells = GridCells.Adaptive(100.dp), verticalArrangement = Arrangement.Center) {

        item {
            Text(
                text = "Title:",
                color = MaterialTheme.colors.disabledBackground
            )
        }

        item {
            BasicTextField(
                value = title.value ?: "",
                onValueChange = { value -> setTitle(value) },
                modifier = Modifier.fillMaxWidth().background(color = MaterialTheme.colors.buttonBackground)
                    .padding(4.dp),
                textStyle = TextStyle(color = MaterialTheme.colors.primary)
            )
        }
    }
}