@file:OptIn(InternalAPI::class)

package com.dropbox.componentbox

import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.ComponentBox
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.ContentNegotiation
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.websocket.DefaultClientWebSocketSession
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.sendSerialized
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.HttpMethod
import io.ktor.http.Url
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.KotlinxWebsocketSerializationConverter
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.InternalAPI
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString

class PreviewApi {
    private val client = HttpClient(CIO) {
        // install(HttpTimeout) {
        //     connectTimeoutMillis = 10_000
        //     socketTimeoutMillis = 10_000
        //     requestTimeoutMillis = 10_000
        // }

        install(ContentNegotiation) {
            json()
        }

        install(WebSockets) {
            contentConverter = KotlinxWebsocketSerializationConverter(kotlinx.serialization.json.Json)
            pingInterval = 500
        }
    }
    private val address = Url("http://localhost:8080")

    fun sync(
        root: ComponentBox.Screen = ComponentBox.Screen(
            title = "",
            verticalArrangement = Arrangement.Start,
            horizontalAlignment = Alignment.Start,
            components = listOf()
        )
    ) {
        try {
            runBlocking {
                val response = client.post(address) {
                    contentType(Json)
                    setBody(root)
                }
            }
        } catch (throwable: Throwable) {
            println(throwable.toString())
        }
    }

    fun push(root: ComponentBox.Screen) {
        runBlocking {
            client.webSocket(method = HttpMethod.Get, host = "localhost", port = 8080, path = "/push") {
                sendSerialized(root)
            }
        }
    }

    fun feed(root: ComponentBox.Screen) {
        runBlocking {
            client.webSocket("ws://localhost:8080/websocket") {
                sendSerialized(root)
            }
        }
    }
}

suspend fun DefaultClientWebSocketSession.push(root: ComponentBox.Screen) {
    sendSerialized(root)
}

suspend fun DefaultClientWebSocketSession.pull(mutableStateFlow: MutableStateFlow<ComponentBox.Screen>) {

    try {
        val flow: Flow<ComponentBox.Screen> = incoming
            .consumeAsFlow()
            .mapNotNull { it as? Frame.Text }
            .map { it.readText() }
            .map { kotlinx.serialization.json.Json.decodeFromString(it) }

        mutableStateFlow.emitAll(flow)
    } catch (_: Exception) {

    }
}