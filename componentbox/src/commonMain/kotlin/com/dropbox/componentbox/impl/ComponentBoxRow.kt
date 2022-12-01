package com.dropbox.componentbox.impl

import com.dropbox.componentbox.component.Component
import com.dropbox.componentbox.component.Row
import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.Modifier

internal class ComponentBoxRow(
    override var modifier: Modifier? = null,
    override var actions: Actions? = null,
    override val components: MutableList<Component>? = null,
    override var horizontalArrangement: Arrangement.Horizontal? = null,
    override var verticalAlignment: Alignment.Vertical? = null,
) : Row