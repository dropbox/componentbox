package com.dropbox.componentbox.model.impl

import com.dropbox.componentbox.model.ComponentBoxData
import com.dropbox.componentbox.model.ComponentBoxNetworkResponse

internal class RealComponentBoxNetworkResponse<Data : ComponentBoxData>(
    override val data: Data,
    override val manifestUrl: String
) : ComponentBoxNetworkResponse<Data>