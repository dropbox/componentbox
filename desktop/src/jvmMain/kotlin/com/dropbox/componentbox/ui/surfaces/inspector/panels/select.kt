@file:OptIn(ExperimentalFoundationApi::class)

package com.dropbox.componentbox.ui.surfaces.inspector.panels

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.ui.theme.buttonBackground
import com.dropbox.componentbox.ui.theme.disabledBackground
import com.dropbox.componentbox.ui.theme.inverseStandardBackground
import com.dropbox.componentbox.utils.name
import androidx.compose.foundation.layout.Arrangement as RealArrangement

@Composable
fun <T> select(
    state: MutableState<T?>,
    label: String,
    options: List<T>,
    onSelect: (value: T) -> Unit
) {
    val isExpanded = remember { mutableStateOf(false) }

    LazyVerticalGrid(cells = GridCells.Adaptive(100.dp), verticalArrangement = RealArrangement.Center) {

        item {
            Text(
                text = label,
                color = MaterialTheme.colors.disabledBackground
            )
        }

        item {
            Box(modifier = Modifier.fillMaxWidth()) {

                Text(
                    text = state.value.name(),
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .clickable { isExpanded.value = true }
                        .background(color = MaterialTheme.colors.buttonBackground)
                        .fillMaxWidth()
                )

                DropdownMenu(
                    modifier = Modifier.background(color = MaterialTheme.colors.buttonBackground).height(300.dp),
                    expanded = isExpanded.value,
                    onDismissRequest = { isExpanded.value = false }) {

                    options.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                onSelect(option)
                                isExpanded.value = false
                            },
                            modifier = Modifier
                                .background(color = MaterialTheme.colors.background)
                                .padding(0.dp)
                                .fillMaxWidth(),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(text = option.name(), color = MaterialTheme.colors.inverseStandardBackground)
                        }
                    }
                }
            }
        }
    }
}