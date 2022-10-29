package com.dropbox.componentbox.campaigns.android.feature.account.data

import com.dropbox.componentbox.campaigns.android.feature.account.data.impl.RealCampaign
import com.dropbox.componentbox.model.ComponentBoxData

interface Campaign<Data : ComponentBoxData> {
    val manifestUrl: String
    val data: Data

    companion object {
        fun <Data : ComponentBoxData> of(manifestUrl: String, data: Data): Campaign<Data> =
            RealCampaign(manifestUrl, data)
    }
}