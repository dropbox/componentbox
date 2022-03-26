package com.dropbox.componentbox.server

import com.dropbox.componentbox.server.plugins.configureHTTP
import com.dropbox.componentbox.server.plugins.configureRouting
import com.dropbox.componentbox.server.plugins.configureSerialization
import com.dropbox.componentbox.server.plugins.configureSockets
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureHTTP()
        configureSerialization()
        configureSockets()
    }.start()
}