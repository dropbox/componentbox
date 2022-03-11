package com.dropbox.componentbox.presentation

import com.dropbox.componentbox.foundation.ComponentBox


data class ComponentBoxViewModel<C : ComponentBox>(
    val root: C? = null
)




