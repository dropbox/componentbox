package com.dropbox.componentbox.samples.counter.server.ui.dynamic

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.ComponentBoxExport
import com.dropbox.componentbox.Forest
import com.dropbox.componentbox.Tree
import com.dropbox.componentbox.model.statefulComponentBox

@Composable
@ComponentBoxExport
fun hybridForest() = statefulComponentBox<Forest.Dynamic?>(init = null) {
    hybridForestUI()
}

@Composable
fun hybridForestUI() = Forest {
    tree("increment_button", Tree { IncrementButton() })
    tree("decrement_button", Tree { DecrementButton() })
}