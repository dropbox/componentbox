package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline


import app.cash.zipline.Zipline

val zipline by lazy { Zipline.get() }

@OptIn(ExperimentalJsExport::class)
@JsExport
fun main() {
    zipline.bind<CampaignsComponentBoxService>(
        name = "CampaignsComponentBoxService",
        instance = RealCampaignsComponentBoxService()
    )
}