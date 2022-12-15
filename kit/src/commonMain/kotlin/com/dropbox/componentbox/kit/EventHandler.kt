package com.dropbox.componentbox.kit

import com.dropbox.componentbox.foundation.ComponentBoxEvent

interface EventHandler {
    fun handle(event: ComponentBoxEvent?)
}