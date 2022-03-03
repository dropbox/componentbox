@file:OptIn(ExperimentalFoundationApi::class)

package com.dropbox.componentbox.ui.surfaces.inspector.panels

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
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.ui.theme.buttonBackground
import com.dropbox.componentbox.ui.theme.disabledBackground

@Composable
fun textInput(state: MutableState<String>, label: String, onValueChange: (value: String) -> Unit) {

    LazyVerticalGrid(cells = GridCells.Adaptive(100.dp), verticalArrangement = Arrangement.Center) {

        item {
            Text(
                text = label,
                color = MaterialTheme.colors.disabledBackground
            )
        }

        item {
            BasicTextField(
                value = state.value,
                onValueChange = { value -> onValueChange(value) },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.buttonBackground)
                    .padding(4.dp),
                textStyle = TextStyle(color = MaterialTheme.colors.primary)
            )
        }
    }
}