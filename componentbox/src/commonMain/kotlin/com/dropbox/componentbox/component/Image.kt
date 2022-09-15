package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Alignment

sealed interface Image : Asset {
    val contentDescription: String?
    var alignment: Alignment
    var contentScale: ContentScale

    interface Network<Id : Any> : Image {
        var lightUrl: String
        var darkUrl: String
        var fallback: Local<Id>?
    }

    interface Local<Id : Any> : Image {
        var id: Id

        interface Drawable<Id : Any> : Local<Id>
        interface Vector<Id : Any> : Local<Id>
        interface Raw<Id : Any> : Local<Id>
    }

    interface ContentScale
}