package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import app.cash.zipline.Zipline
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

expect class CampaignsComponentBoxController {
    fun models(
        ziplineInitializer: (Zipline) -> Unit
    ): StateFlow<CampaignsComponentBoxModel?>
}


expect fun campaignsComponentBoxControllerOf(
    ziplineMetadata: ZiplineMetadata,
    coroutineDispatcher: CoroutineDispatcher,
    coroutineScope: CoroutineScope
): CampaignsComponentBoxController