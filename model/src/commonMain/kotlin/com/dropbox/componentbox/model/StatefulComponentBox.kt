package com.dropbox.componentbox.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.Tree

@Composable
fun StatefulComponentBox(componentBox: @Composable () -> @ComponentBox Tree) {

    val modelProvider = remember { ComposableModelProvider() }

    CompositionLocalProvider(LocalComposableModelProvider provides modelProvider) {
        componentBox()
    }
}