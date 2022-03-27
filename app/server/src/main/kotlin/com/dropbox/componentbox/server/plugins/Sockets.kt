package com.dropbox.componentbox.server.plugins

import io.ktor.serialization.kotlinx.KotlinxWebsocketSerializationConverter
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.websocket.WebSockets
import io.ktor.websocket.DefaultWebSocketSession
import io.ktor.websocket.pingPeriod
import io.ktor.websocket.timeout
import kotlinx.serialization.json.Json
import java.time.Duration

data class ComponentBoxConnection(
    val session: DefaultWebSocketSession
)

fun Application.configureSockets() {

    install(WebSockets) {
        pingPeriod = Duration.ofSeconds(15)
        timeout = Duration.ofSeconds(15)
        maxFrameSize = Long.MAX_VALUE
        masking = false
        contentConverter = KotlinxWebsocketSerializationConverter(Json)
    }
}