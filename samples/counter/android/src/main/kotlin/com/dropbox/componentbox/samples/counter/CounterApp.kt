package com.dropbox.componentbox.samples.counter

import android.app.Application
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readBytes


class CounterApp : Application() {


}


class ComponentBoxClient {
    private val client = HttpClient()
    suspend operator fun invoke(binaryUrl: String): ByteArray {
        val response: HttpResponse = client.get(binaryUrl)
        return response.readBytes()
    }
}