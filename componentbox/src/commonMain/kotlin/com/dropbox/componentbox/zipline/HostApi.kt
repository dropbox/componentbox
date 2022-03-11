package com.dropbox.componentbox.zipline

import app.cash.zipline.ZiplineService

interface HostApi : ZiplineService {
    suspend fun httpCall(url: String, headers: Map<String, String>): String
}