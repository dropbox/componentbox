package com.dropbox.componentbox.android.preview

import com.dropbox.componentbox.foundation.ComponentBox
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.websocket.DefaultClientWebSocketSession
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.client.request.get
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

class PreviewApi(
    private val client: HttpClient
) {
    suspend fun pull(url: String): ComponentBox.Screen {
        val response = client.get(url)
        println(response)
        return response.body()
    }

    // suspend fun httpCall(url: String, headers: Map<String, String>): String {
    //     return suspendCancellableCoroutine { continuation ->
    //         val call = client.newCall(
    //             Request.Builder()
    //                 .url(url)
    //                 .headers(headers.toHeaders())
    //                 .build()
    //         )
    //         call.enqueue(object : Callback {
    //             override fun onFailure(call: Call, e: IOException) {
    //                 continuation.resumeWith(Result.failure(e))
    //             }
    //
    //             override fun onResponse(call: Call, response: Response) {
    //                 val responseString = response.body!!.string()
    //                 println(responseString)
    //                 continuation.resumeWith(Result.success(responseString))
    //             }
    //         })
    //     }
    // }
}

suspend fun DefaultClientWebSocketSession.pull(mutableStateFlow: MutableStateFlow<ComponentBox.Screen?>) {

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

class WebSocketApi(
    private val client: HttpClient,
    private val mutableStateFlow: MutableStateFlow<ComponentBox.Screen?>
) {
    fun subscribe() {
        runBlocking {
            client.webSocket("ws://10.0.2.2:8080/websocket") {
                val pullRoutine = launch { pull(mutableStateFlow) }
                pullRoutine.join()
            }
        }
    }
}