package com.dropbox.componentbox.samples.discovery

import app.cash.zipline.ZiplineService

interface HostApi: ZiplineService {
    suspend fun httpCall(url: String, headers: Map<String, String>): String
}