package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.BorderStroke
import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.Shape

interface Surface {
    var shape: Shape?
    var color: Color?
    var contentColor: Color?
    var borderStroke: BorderStroke?
    var elevation: Int?
    val components: List<Component>?
}