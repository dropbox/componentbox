package com.dropbox.componentbox.discovery.discovery.scoping

import com.dropbox.componentbox.Inflater
import com.dropbox.componentbox.ResourceProvider
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