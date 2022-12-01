package com.dropbox.componentbox.impl

import com.dropbox.componentbox.component.Icon
import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.Modifier

internal class ComponentBoxIcon<Id : Any>(
    override var id: Id,
    override var modifier: Modifier? = null,
    override var actions: Actions? = null,
    override var color: Color? = null,
    override val contentDescription: String?,
) : Icon<Id>