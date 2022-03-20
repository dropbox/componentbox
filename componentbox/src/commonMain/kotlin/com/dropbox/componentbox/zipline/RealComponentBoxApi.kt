package com.dropbox.componentbox.zipline

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

class RealComponentBoxApi : ComponentBoxApi {
    private val client: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    override suspend fun httpCall(url: String, headers: Map<String, String>): String {
        return client.get(url) {
            headers.map { header(it.key, it.value) }
        }.body()
    }
}