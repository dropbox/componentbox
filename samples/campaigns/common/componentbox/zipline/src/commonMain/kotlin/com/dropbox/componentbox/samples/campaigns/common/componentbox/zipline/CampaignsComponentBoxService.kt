package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.foundation.ComponentBoxEvent
import com.dropbox.componentbox.zipline.ComponentBoxModel
import com.dropbox.componentbox.zipline.ComponentBoxService
import com.dropbox.componentbox.zipline.ComponentBoxState


data class CampaignsComponentBoxState(
    val componentBox: ComponentBox? = null
) : ComponentBoxState

sealed class CampaignsComponentBoxEvent : ComponentBoxEvent {
    object Dismiss : CampaignsComponentBoxEvent()
}

interface CampaignsComponentBoxModel : ComponentBoxModel<CampaignsComponentBoxState, CampaignsComponentBoxEvent>

typealias CampaignsComponentBoxService = ComponentBoxService<CampaignsComponentBoxModel, CampaignsComponentBoxState, CampaignsComponentBoxEvent>