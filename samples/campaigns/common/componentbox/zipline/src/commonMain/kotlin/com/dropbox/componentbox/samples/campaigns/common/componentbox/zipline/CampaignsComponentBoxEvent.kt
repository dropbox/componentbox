package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import com.dropbox.componentbox.foundation.ComponentBoxEvent
import kotlinx.serialization.Serializable

@Serializable
sealed class CampaignsComponentBoxEvent : ComponentBoxEvent {
    @Serializable
    object Dismiss : CampaignsComponentBoxEvent()
}