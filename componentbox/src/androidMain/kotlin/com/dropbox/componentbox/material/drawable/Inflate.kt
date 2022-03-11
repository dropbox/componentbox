package com.dropbox.componentbox.material.drawable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import coil.compose.rememberImagePainter
import com.dropbox.componentbox.foundation.COMPONENT_BOX_FALLBACK_DRAWABLE_URL
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.util.translate

@Composable
fun Component.Drawable.Inflate(context: Context?) {
    @DrawableRes
    val drawableResId = context?.themer?.getDrawableResId(name)

    val painter = if (drawableResId != null) {
        painterResource(drawableResId)
    } else {
        rememberImagePainter(data = url ?: COMPONENT_BOX_FALLBACK_DRAWABLE_URL)
    }

    Image(
        painter = painter,
        modifier = modifier.build(),
        contentScale = contentScale.translate(),
        contentDescription = contentDescription
    )
}
