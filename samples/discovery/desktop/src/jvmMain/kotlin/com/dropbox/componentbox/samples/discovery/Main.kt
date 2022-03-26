package com.dropbox.componentbox.samples.discovery

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import app
import com.dropbox.componentbox.samples.discovery.RealInflater
import com.dropbox.componentbox.samples.discovery.RealResourceProvider
import com.dropbox.componentbox.samples.discovery.RealThemer
import java.awt.Window

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Discovery") {
        app(RealInflater(), RealThemer(), RealResourceProvider())
    }
}