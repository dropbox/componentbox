package com.dropbox.componentbox.zipline

import app.cash.zipline.ZiplineService
import com.dropbox.componentbox.foundation.ComponentBox

interface ComponentBoxApi : ZiplineService {
    suspend fun httpCall(url: String, headers: Map<String, String>): String
}