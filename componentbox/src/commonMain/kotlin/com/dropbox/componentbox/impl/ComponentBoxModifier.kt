package com.dropbox.componentbox.impl

import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.Margin
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.foundation.Padding

internal class ComponentBoxModifier(
    override var fillMaxSize: Boolean? = null,
    override var fillMaxHeight: Boolean? = null,
    override var fillMaxWidth: Boolean? = null,
    override var height: Int? = null,
    override var width: Int? = null,
    override var padding: Padding? = null,
    override var margin: Margin? = null,
    override var background: Color? = null,
    override var weight: Float? = null
) : Modifier


