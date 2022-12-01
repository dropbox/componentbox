package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.impl.ComponentBoxDrawable
import com.dropbox.componentbox.impl.ComponentBoxRaw
import com.dropbox.componentbox.impl.ComponentBoxVector

interface LocalImage<Id : Any> : Image {
    var id: Id

    interface Drawable<Id : Any> : LocalImage<Id> {
        companion object {
            fun <Id : Any> of(
                id: Id,
                modifier: Modifier? = null,
                actions: Actions? = null,
                contentDescription: String? = null,
                alignment: Alignment? = null,
                contentScale: ContentScale? = null,
            ): Drawable<Id> = ComponentBoxDrawable(
                id = id,
                modifier = modifier,
                actions = actions,
                contentDescription = contentDescription,
                alignment = alignment,
                contentScale = contentScale,
            )
        }
    }

    interface Vector<Id : Any> : LocalImage<Id> {
        companion object {
            fun <Id : Any> of(
                id: Id,
                modifier: Modifier? = null,
                actions: Actions? = null,
                contentDescription: String? = null,
                alignment: Alignment? = null,
                contentScale: ContentScale? = null,
            ): Vector<Id> = ComponentBoxVector(
                id = id,
                modifier = modifier,
                actions = actions,
                contentDescription = contentDescription,
                alignment = alignment,
                contentScale = contentScale,
            )
        }
    }

    interface Raw<Id : Any> : LocalImage<Id> {
        companion object {
            fun <Id : Any> of(
                id: Id,
                modifier: Modifier? = null,
                actions: Actions? = null,
                contentDescription: String? = null,
                alignment: Alignment? = null,
                contentScale: ContentScale? = null,
            ): Raw<Id> = ComponentBoxRaw(
                id = id,
                modifier = modifier,
                actions = actions,
                contentDescription = contentDescription,
                alignment = alignment,
                contentScale = contentScale,
            )
        }
    }
}