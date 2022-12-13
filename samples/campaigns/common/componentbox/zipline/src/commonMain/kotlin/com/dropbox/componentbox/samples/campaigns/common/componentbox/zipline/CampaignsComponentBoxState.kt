package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import com.dropbox.componentbox.ComponentBox
import kotlinx.serialization.Serializable

@Serializable
data class CampaignsComponentBoxState(
    val componentBox: ComponentBox? = null
)

