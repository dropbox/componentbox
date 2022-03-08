package com.dropbox.componentbox.discovery.discovery.scoping

import com.dropbox.componentbox.Inflater
import com.dropbox.componentbox.samples.discovery.RealInflater

data class AppScope(
    val inflater: Inflater
)

fun appScope() = AppScope(
    inflater = RealInflater()
)