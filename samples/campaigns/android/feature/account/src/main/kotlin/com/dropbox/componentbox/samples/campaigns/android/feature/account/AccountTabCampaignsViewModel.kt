package com.dropbox.componentbox.samples.campaigns.android.feature.account

import app.cash.zipline.Zipline
import com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline.CampaignsComponentBoxEvent
import com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline.CampaignsComponentBoxState
import com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline.ZiplineMetadata
import com.dropbox.componentbox.samples.campaigns.common.viewmodel.CampaignsComponentBoxViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class AccountTabCampaignsViewModel(initialState: CampaignsComponentBoxState = CampaignsComponentBoxState()) : CampaignsComponentBoxViewModel(initialState) {
    override suspend fun ziplineMetadataFetcher(): ZiplineMetadata = ZiplineMetadata(
        manifestUrl = "http://10.0.2.2:8080/manifest.zipline.json",
        serviceName = "CampaignsComponentBoxService",
        applicationName = "com.dropbox.componentbox.samples.campaigns"
    )

    override fun ziplineInitializer(zipline: Zipline) {}


    private val _events = MutableSharedFlow<CampaignsComponentBoxEvent>()
    override val events: Flow<CampaignsComponentBoxEvent> = _events

    override fun onEvent(event: CampaignsComponentBoxEvent) = when (event) {
        CampaignsComponentBoxEvent.Dismiss -> {}
    }

}