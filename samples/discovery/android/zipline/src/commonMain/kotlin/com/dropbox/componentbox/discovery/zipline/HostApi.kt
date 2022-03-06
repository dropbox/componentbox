package com.dropbox.componentbox.discovery.zipline

import app.cash.zipline.ZiplineService

interface HostApi: ZiplineService {
    suspend fun httpCall(url: String, headers: Map<String, String>): String
}