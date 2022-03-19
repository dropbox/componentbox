package com.dropbox.componentbox.discovery.desktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import app
import com.dropbox.componentbox.samples.discovery.RealInflater
import com.dropbox.componentbox.samples.discovery.RealResourceProvider
import com.dropbox.componentbox.samples.discovery.RealThemer

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Discovery") {
        app(RealInflater(), RealThemer(), RealResourceProvider())
    }
}