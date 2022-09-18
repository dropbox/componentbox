package com.dropbox.componentbox.impl

import com.dropbox.componentbox.component.ContentScale
import com.dropbox.componentbox.component.LocalImage
import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Modifier

internal class ComponentBoxDrawable<Id : Any>(
    override var id: Id,
    override var modifier: Modifier? = null,
    override var actions: Actions? = null,
    override val contentDescription: String? = null,
    override var alignment: Alignment? = null,
    override var contentScale: ContentScale? = null,
) : LocalImage.Drawable<Id>