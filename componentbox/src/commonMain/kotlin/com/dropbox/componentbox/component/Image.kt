package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Alignment

sealed interface Image : Asset {
    val contentDescription: String?
    var alignment: Alignment?
    var contentScale: ContentScale?
}