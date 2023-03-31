package com.dropbox.componentbox.samples.counter.server

import com.dropbox.componentbox.ComponentBoxExport
import com.dropbox.componentbox.SerializableComponentBox
import com.dropbox.componentbox.samples.counter.server.ui.static.static


@ComponentBoxExport
class v1 {
    @SerializableComponentBox
    fun CounterScreen() = static
}