package com.dropbox.componentbox.campaigns.android.feature.account.data.impl

import com.dropbox.componentbox.campaigns.android.feature.account.data.Campaign
import com.dropbox.componentbox.model.ComponentBoxData

class RealCampaign<Data : ComponentBoxData>(
    override val manifestUrl: String,
    override val data: Data
) : Campaign<Data>