package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.impl.ComponentBoxNetworkImage

interface NetworkImage<Id : Any> : Image {
    var lightUrl: String
    var darkUrl: String
    var fallback: LocalImage<Id>?

    companion object {
        fun <Id : Any> of(
            lightUrl: String,
            darkUrl: String,
            modifier: Modifier? = null,
            actions: Actions? = null,
            contentDescription: String? = null,
            alignment: Alignment? = null,
            contentScale: ContentScale? = null,
            fallback: LocalImage<Id>? = null,
        ): NetworkImage<Id> = ComponentBoxNetworkImage(
            lightUrl = lightUrl,
            darkUrl = darkUrl,
            modifier = modifier,
            actions = actions,
            contentDescription = contentDescription,
            alignment = alignment,
            contentScale = contentScale,
            fallback = fallback,
        )
    }
}