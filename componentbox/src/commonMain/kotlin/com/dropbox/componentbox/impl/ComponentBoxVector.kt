package com.dropbox.componentbox.impl


import com.dropbox.componentbox.component.ContentScale
import com.dropbox.componentbox.component.LocalImage
import com.dropbox.componentbox.foundation.Events
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Modifier

internal class ComponentBoxVector<Id : Any>(
    override var id: Id,
    override var modifier: Modifier? = null,
    override var events: Events? = null,
    override val contentDescription: String? = null,
    override var alignment: Alignment? = null,
    override var contentScale: ContentScale? = null,
) : LocalImage.Vector<Id>