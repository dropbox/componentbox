package com.dropbox.componentbox.impl

import com.dropbox.componentbox.component.ContentScale
import com.dropbox.componentbox.component.LocalImage
import com.dropbox.componentbox.component.NetworkImage
import com.dropbox.componentbox.foundation.Events
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Modifier

internal class ComponentBoxNetworkImage<Id : Any>(
    override var lightUrl: String,
    override var darkUrl: String,
    override var modifier: Modifier? = null,
    override var events: Events? = null,
    override val contentDescription: String? = null,
    override var alignment: Alignment? = null,
    override var contentScale: ContentScale? = null,
    override var fallback: LocalImage<Id>? = null,
) : NetworkImage<Id>