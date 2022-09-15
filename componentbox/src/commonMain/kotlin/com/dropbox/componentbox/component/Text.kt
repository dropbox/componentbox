package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.TextStyle

interface Text : Component {
    var text: String?
    var color: Color?
    var textStyle: TextStyle?
}