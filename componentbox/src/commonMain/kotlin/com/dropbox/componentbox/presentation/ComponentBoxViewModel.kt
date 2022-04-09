package com.dropbox.componentbox.presentation

import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.foundation.Parcelable
import com.dropbox.componentbox.foundation.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class ComponentBoxViewModel<C : ComponentBox>(
    val root: C? = null
) : Parcelable




