package com.dropbox.componentbox.server

import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.server.plugins.ComponentBoxConnection
import com.dropbox.componentbox.server.plugins.configureHTTP
import com.dropbox.componentbox.server.plugins.configureSerialization
import com.dropbox.componentbox.server.plugins.configureSockets
import io.ktor.http.ContentType
import io.ktor.http.content.OutgoingContent
import io.ktor.serialization.ContentConverter
import io.ktor.serialization.WebsocketContentConverter
import io.ktor.serialization.WebsocketConverterNotFoundException
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.serialization.kotlinx.KotlinxWebsocketSerializationConverter
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.ContentNegotiation
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import io.ktor.server.websocket.converter
import io.ktor.server.websocket.sendSerialized
import io.ktor.server.websocket.webSocket
import io.ktor.util.reflect.TypeInfo
import io.ktor.util.reflect.instanceOf
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.charsets.Charset
import io.ktor.websocket.send
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialFormat
import java.util.Collections



fun main() {
    embeddedServer(Netty, port = 8080, host = "localhost") {
        configureHTTP()
        configureSockets()
        install(ContentNegotiation) {
            json()
        }

        val root: MutableStateFlow<ComponentBox.Screen?> = MutableStateFlow(null)
        val connections = Collections.synchronizedSet<ComponentBoxConnection?>(LinkedHashSet())

        routing {

            get("/") {

                if (root.value != null) {
                    call.respond(root.value!!)
                } else {
                    call.respondText("Hello World!")
                }
            }

            post("/") {
                root.value = call.receive()
                call.respond(200)
            }

            webSocket("/websocket") {

                val connection = ComponentBoxConnection(this)
                connections += connection

                while (true) {
                    when (root.value) {
                        null -> send("No value")
                        else -> sendSerialized(root.value!!)
                    }
                }
            }
        }
    }.start()
}