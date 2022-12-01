package com.dropbox.componentbox.impl

import com.dropbox.componentbox.component.Component
import com.dropbox.componentbox.component.OutlinedButton
import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Modifier

internal class ComponentBoxOutlinedButton(
    override var components: MutableList<Component>? = null,
    override var disabled: Boolean? = null,
    override var modifier: Modifier? = null,
    override var actions: Actions? = null,
) : OutlinedButton