package com.dropbox.componentbox.campaigns.xplat.componentbox

import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.model.ComponentBoxState

actual class CampaignsComponentBoxState actual constructor(
    val root: ComponentBox?,
    val destination: CampaignsComponentBoxDestination?
) : ComponentBoxState