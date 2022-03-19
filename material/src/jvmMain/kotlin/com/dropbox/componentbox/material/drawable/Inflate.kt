package com.dropbox.componentbox.material.drawable

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.res.painterResource
import com.dropbox.componentbox.foundation.COMPONENT_BOX_FALLBACK_DRAWABLE_URL
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.util.alignment
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.util.translate
import java.io.ByteArrayOutputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.imageio.ImageIO

@Composable
actual fun Component.Drawable.Inflate(context: Context?) {


    val imageResPath = context?.themer?.getDrawableResPath(name)

    if (imageResPath != null) {
        Image(
            painter = painterResource(imageResPath),
            modifier = modifier.build(),
            contentScale = contentScale.translate(),
            contentDescription = contentDescription,
            alignment = alignment.alignment()
        )
    } else {
        val imageBitmap = this.url.toImageBitmap() ?: COMPONENT_BOX_FALLBACK_DRAWABLE_URL.toImageBitmap()
        if (imageBitmap != null) {
            Image(
                bitmap = imageBitmap,
                modifier = modifier.build(),
                contentScale = contentScale.translate(),
                contentDescription = contentDescription,
                alignment = alignment.alignment()
            )

        }
    }
}


private fun String?.toImageBitmap(): ImageBitmap? {
    if (this == null) return null

    val url = URL(this)
    val connection = url.openConnection() as HttpURLConnection
    connection.connect()

    val inputStream = connection.inputStream
    val bufferedImage = ImageIO.read(inputStream)

    val stream = ByteArrayOutputStream()
    ImageIO.write(bufferedImage, "png", stream)
    val byteArray = stream.toByteArray()

    return org.jetbrains.skia.Image.makeFromEncoded(byteArray).toComposeImageBitmap()
}
