package com.dropbox.componentbox.samples.counter.server.ui.dynamic

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.ComponentBoxExport
import com.dropbox.componentbox.Forest
import com.dropbox.componentbox.model.statefulComponentBox

@Composable
@ComponentBoxExport
fun flowForest() = statefulComponentBox<Forest.Dynamic?>(init = null) {
    flowForestUI()
}


@Composable
fun flowForestUI() = Forest { }