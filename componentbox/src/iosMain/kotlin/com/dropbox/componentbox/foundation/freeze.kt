package com.dropbox.componentbox.foundation

import com.dropbox.componentbox.ComponentBoxClient
import kotlin.native.concurrent.freeze

fun ComponentBoxClient.freeze() = this.freeze()