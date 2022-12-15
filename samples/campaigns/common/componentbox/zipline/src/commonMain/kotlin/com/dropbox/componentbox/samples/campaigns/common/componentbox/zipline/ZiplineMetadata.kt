package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import kotlinx.serialization.Serializable

@Serializable
data class ZiplineMetadata(
    val manifestUrl: String,
    val serviceName: String,
    val applicationName: String
)