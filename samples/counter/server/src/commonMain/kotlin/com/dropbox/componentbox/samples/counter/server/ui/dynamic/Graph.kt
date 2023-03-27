package com.dropbox.componentbox.samples.counter.server.ui.dynamic

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.ComponentBoxExport
import com.dropbox.componentbox.Graph
import com.dropbox.componentbox.model.statefulComponentBox

@Composable
@ComponentBoxExport
fun graph() = statefulComponentBox(init = null) {
    Graph(start = "screen") {
        forest("hybrid", hybridForestUI())
        forest("flow", flowForestUI())
        forest("screen", screenForestUI())
    }
}