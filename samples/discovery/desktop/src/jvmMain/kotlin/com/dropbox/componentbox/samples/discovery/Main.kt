package com.dropbox.componentbox.samples.discovery

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import app

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Discovery",
        state = WindowState(size = DpSize(1600.dp, 1200.dp))
    ) {
        app(RealInflater(), RealThemer(), RealResourceProvider())
    }
}