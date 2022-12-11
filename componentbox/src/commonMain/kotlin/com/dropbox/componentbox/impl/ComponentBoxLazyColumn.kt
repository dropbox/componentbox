package com.dropbox.componentbox.impl

import com.dropbox.componentbox.component.Component
import com.dropbox.componentbox.component.LazyColumn
import com.dropbox.componentbox.foundation.Events
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.Modifier

internal class ComponentBoxLazyColumn(
    override var verticalArrangement: Arrangement.Vertical? = null,
    override var horizontalAlignment: Alignment.Horizontal? = null,
    override var modifier: Modifier? = null,
    override var events: Events? = null,
    override val components: MutableList<Component>? = null,
) : LazyColumn