package com.dropbox.componentbox

import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.ComponentBox
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
public object ComponentBoxClient {
    private val safeJson = Json { isLenient = true; ignoreUnknownKeys = true }

    val client: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(safeJson)
        }

        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    suspend fun fetchScreen(url: String): ComponentBox.Screen = client.get(url).body()

    suspend inline fun <reified C : ComponentBox> fetchComponentBox(url: String): C = client.get(url).body()
}

fun <T> T.freeze(): T = this.freeze()

fun Long?.toHexString(): String = this.toHexString()