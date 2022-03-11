package com.dropbox.componentbox.discovery.discovery.scoping

import com.dropbox.componentbox.foundation.Inflater
import com.dropbox.componentbox.foundation.ResourceProvider
import com.dropbox.componentbox.samples.discovery.RealInflater
import com.dropbox.componentbox.samples.discovery.RealResourceProvider

data class AppScope(
    val inflater: Inflater,
    val resourceProvider: ResourceProvider
)

fun appScope() = AppScope(
    inflater = RealInflater(),
    resourceProvider = RealResourceProvider()
)