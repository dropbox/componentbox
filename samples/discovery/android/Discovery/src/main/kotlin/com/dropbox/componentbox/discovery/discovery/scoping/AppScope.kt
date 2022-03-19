package com.dropbox.componentbox.discovery.discovery.scoping

import com.dropbox.componentbox.discovery.discovery.DiscoveryManager
import com.dropbox.componentbox.discovery.discovery.DiscoveryThemer
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.foundation.Inflater
import com.dropbox.componentbox.samples.discovery.RealInflater
import com.dropbox.componentbox.samples.discovery.RealResourceProvider

data class AppScope(
    val inflater: Inflater,
    val resourceProvider: ResourceProvider,
    val context: Context
)

fun appScope() = AppScope(
    inflater = RealInflater(),
    resourceProvider = RealResourceProvider(),
    context = Context(RealInflater(), DiscoveryThemer(), DiscoveryManager())
)