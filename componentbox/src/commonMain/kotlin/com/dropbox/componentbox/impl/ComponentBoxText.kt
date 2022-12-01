package com.dropbox.componentbox.impl

import com.dropbox.componentbox.component.Text
import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.foundation.TextStyle

internal class ComponentBoxText(
    override var modifier: Modifier? = null,
    override var actions: Actions? = null,
    override var text: String? = null,
    override var color: Color? = null,
    override var textStyle: TextStyle? = null,
): Text