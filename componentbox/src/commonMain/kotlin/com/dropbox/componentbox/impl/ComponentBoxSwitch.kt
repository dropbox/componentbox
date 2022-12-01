package com.dropbox.componentbox.impl

import com.dropbox.componentbox.component.Switch
import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Modifier

internal class ComponentBoxSwitch(
    override var modifier: Modifier? = null,
    override var actions: Actions? = null,
    override var checked: Boolean? = null,
) : Switch