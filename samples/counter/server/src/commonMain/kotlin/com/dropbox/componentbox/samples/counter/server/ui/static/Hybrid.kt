package com.dropbox.componentbox.samples.counter.server.ui.static

import com.dropbox.componentbox.forest
import kotlinx.serialization.Serializable
import com.dropbox.componentbox.tree as static


@Serializable
val staticHybrid = forest {
    tree("increment_button", static { incrementButton })
    tree("decrement_button", static { decrementButton })
}