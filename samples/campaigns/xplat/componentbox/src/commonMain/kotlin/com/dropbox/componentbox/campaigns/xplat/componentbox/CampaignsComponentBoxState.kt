package com.dropbox.componentbox.campaigns.xplat.componentbox

import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.model.ComponentBoxState


expect class CampaignsComponentBoxState(
    root: ComponentBox? = null,
    destination: CampaignsComponentBoxDestination? = null
) : ComponentBoxState