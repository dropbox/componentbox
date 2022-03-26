@file:OptIn(InternalAPI::class)

package com.dropbox.componentbox

import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.ComponentBox
import io.ktor.client.HttpClient
import io.ktor.client.plugins.ContentNegotiation
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.Url
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.InternalAPI
import kotlinx.coroutines.runBlocking

class PreviewApi {
    private val client = HttpClient() {
        install(HttpTimeout) {
            connectTimeoutMillis = 10_000
            socketTimeoutMillis = 10_000
            requestTimeoutMillis = 10_000
        }

        install(ContentNegotiation) {
            json()
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
}