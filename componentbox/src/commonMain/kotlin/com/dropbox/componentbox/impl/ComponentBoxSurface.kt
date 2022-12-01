package com.dropbox.componentbox.impl

import com.dropbox.componentbox.component.Component
import com.dropbox.componentbox.component.Surface
import com.dropbox.componentbox.foundation.BorderStroke
import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.Shape

internal class ComponentBoxSurface(
    override var shape: Shape? = null,
    override var color: Color? = null,
    override var contentColor: Color? = null,
    override var borderStroke: BorderStroke? = null,
    override var elevation: Int? = null,
    override val components: List<Component>? = null,
) : Surface