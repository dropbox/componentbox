package com.dropbox.componentbox.campaigns.xplat.componentbox

import app.cash.zipline.Zipline

private val zipline by lazy { Zipline.get() }

@OptIn(ExperimentalJsExport::class)
@JsExport
fun main() {
    zipline.bind<CampaignsComponentBoxService>(
        name = "CampaignsComponentBoxService",
        instance = RealCampaignsComponentBoxService()
    )
}