package com.dropbox.componentbox.samples.discovery

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import app

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Discovery") {
        app(RealInflater(), RealThemer(), RealResourceProvider())
    }
}