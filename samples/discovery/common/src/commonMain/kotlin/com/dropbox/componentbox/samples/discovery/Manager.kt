package com.dropbox.componentbox.samples.discovery

import app.cash.zipline.ZiplineService

interface Manager : ZiplineService {
    fun handleAction(action: DiscoveryAction)
}