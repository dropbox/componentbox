package com.dropbox.componentbox.material.column

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.material.Inflate
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.util.horizontal
import com.dropbox.componentbox.util.vertical

@Composable
fun Component.Column.Inflate(context: Context?) {
    when (this.isLazy) {
        true -> this.LazyColumn(context)
        else -> this.Column(context)
    }
}

@Composable
fun Component.Column.Column(context: Context?) {
    val components = this.components
    val customModifiers = listOf(
        Modifier.background(context?.themer?.toColor(modifier?.background) ?: MaterialTheme.colors.background)
    )

    Column(
        verticalArrangement = verticalArrangement.vertical(),
        horizontalAlignment = horizontalAlignment.horizontal(),
        modifier = this.modifier.build(customModifiers)
    ) {
        components?.forEach { component ->
            component.Inflate()
        }
    }
}

@Composable
fun Component.Column.LazyColumn(context: Context?) {
    val components = this.components
    val customModifiers = listOf(
        Modifier.background(context?.themer?.toColor(modifier?.background) ?: MaterialTheme.colors.background)
    )

    LazyColumn(
        verticalArrangement = verticalArrangement.vertical(),
        horizontalAlignment = horizontalAlignment.horizontal(),
        modifier = modifier.build(customModifiers)
    ) {
        if (components != null) {
            items(components) { component ->
                component.Inflate()
            }
        }
    }
}