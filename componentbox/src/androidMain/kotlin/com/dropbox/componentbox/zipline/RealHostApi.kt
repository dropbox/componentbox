package com.dropbox.componentbox.zipline

import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.*
import okhttp3.Headers.Companion.toHeaders
import java.io.IOException

class RealHostApi(
    private val client: OkHttpClient
) : HostApi {
    override suspend fun httpCall(url: String, headers: Map<String, String>): String {
        return suspendCancellableCoroutine { continuation ->
            val call = client.newCall(
                Request.Builder()
                    .url(url)
                    .headers(headers.toHeaders())
                    .build()
            )
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    continuation.resumeWith(Result.failure(e))
                }

                override fun onResponse(call: Call, response: Response) {
                    val responseString = response.body!!.string()
                    continuation.resumeWith(Result.success(responseString))
                }
            })
        }
    }
}