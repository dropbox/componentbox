package com.dropbox.componentbox.campaigns.xplat.componentbox

import com.dropbox.componentbox.model.zipline

@OptIn(ExperimentalJsExport::class)
@JsExport
fun main() {
    zipline.bind<CampaignsComponentBoxService>(
        name = "CampaignsComponentBoxService",
        instance = RealCampaignsComponentBoxService()
    )
}