package com.dropbox.componentbox.campaigns.xplat.componentbox

import com.dropbox.componentbox.model.ComponentBoxEvent

sealed class CampaignsComponentBoxEvent : ComponentBoxEvent {
    data class Navigate(
        val destination: CampaignsComponentBoxDestination
    ) : CampaignsComponentBoxEvent()
}