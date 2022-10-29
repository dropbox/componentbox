package com.dropbox.componentbox.model

import com.dropbox.componentbox.model.impl.RealComponentBoxNetworkResponse

interface ComponentBoxNetworkResponse<Data : ComponentBoxData> {
    val data: Data
    val manifestUrl: String

    companion object {
        fun <Data : ComponentBoxData> of(
            data: Data,
            manifestUrl: String
        ): ComponentBoxNetworkResponse<Data> =
            RealComponentBoxNetworkResponse(data, manifestUrl)
    }
}
