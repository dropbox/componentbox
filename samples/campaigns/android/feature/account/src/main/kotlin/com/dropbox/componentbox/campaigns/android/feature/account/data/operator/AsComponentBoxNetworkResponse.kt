package com.dropbox.componentbox.campaigns.android.feature.account.data.operator

import com.dropbox.componentbox.campaigns.android.feature.account.data.Campaign
import com.dropbox.componentbox.model.ComponentBoxData
import com.dropbox.componentbox.model.ComponentBoxNetworkResponse

fun <Data : ComponentBoxData> Campaign<Data>.asComponentBoxNetworkResponse(): ComponentBoxNetworkResponse<Data> =
    ComponentBoxNetworkResponse.of(data, manifestUrl)