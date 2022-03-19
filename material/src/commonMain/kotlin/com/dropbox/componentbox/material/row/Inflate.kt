package com.dropbox.componentbox.material.row

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dropbox.componentbox.util.compose
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.material.Inflate
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.util.horizontal
import com.dropbox.componentbox.util.vertical

@Composable
fun Component.Row.Inflate(context: Context?) {
    when (this.isLazy) {
        true -> this.LazyRow(context)
        else -> this.Row(context)
    }
}

@Composable
private fun Component.Row.Row(context: Context?) {
    val backgroundColor = modifier?.background.compose()

    val customModifiers = if (backgroundColor != null) {
        listOf(Modifier.background(backgroundColor))
    } else {
        listOf()
    }

    Row(
        verticalAlignment = verticalAlignment.vertical(),
        horizontalArrangement = horizontalArrangement.horizontal(),
        modifier = modifier.build(customModifiers)
    ) {
        components?.forEach { component ->
            component.Inflate(context)
        }
    }
}

@Composable
private fun Component.Row.LazyRow(context: Context?) {
    val backgroundColor = modifier?.background.compose()

    val customModifiers = if (backgroundColor != null) {
        listOf(Modifier.background(backgroundColor))
    } else {
        listOf()
    }

    LazyRow(
        verticalAlignment = verticalAlignment.vertical(),
        horizontalArrangement = horizontalArrangement.horizontal(),
        modifier = modifier.build(customModifiers)
    ) {
        if (components != null) {
            items(components!!) { component ->
                component.Inflate(context)
            }
        }
    }
}
