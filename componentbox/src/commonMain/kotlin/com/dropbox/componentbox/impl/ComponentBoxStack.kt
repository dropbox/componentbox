package com.dropbox.componentbox.impl

import com.dropbox.componentbox.component.Component
import com.dropbox.componentbox.component.Stack
import com.dropbox.componentbox.foundation.Events
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.Modifier

internal class ComponentBoxStack(
    override var modifier: Modifier? = null,
    override var events: Events? = null,
    override val components: MutableList<Component>? = null,
    override var horizontalArrangement: Arrangement.Horizontal? = null,
    override var verticalAlignment: Alignment.Vertical? = null
) : Stack