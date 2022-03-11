package com.dropbox.componentbox.samples.discovery.vector

import com.dropbox.componentbox.foundation.Icon
import com.dropbox.componentbox.foundation.Icons
import com.dropbox.componentbox.foundation.MultiplatformRes
import com.dropbox.componentbox.foundation.RealVectorRes

actual class DiscoveryIcons : Icons {
    actual val checkmarkCircle = Icon(
        line = RealVectorRes("CheckmarkCircle.Line", "drawable/ic_dig_checkmark_circle_line.xml"),
        fill = RealVectorRes("CheckmarkCircle.Fill", "drawable/ic_dig_checkmark_circle_fill.xml"),
        pictogram = null,
        spot = null,
    )

    actual val fail = Icon(
        line = RealVectorRes("Fail.Line", "drawable/ic_dig_fail_line.xml"),
        fill = RealVectorRes("Fail.Fill", "drawable/ic_dig_fail_fill.xml"),
        pictogram = null,
        spot = null,
    )

    actual val twinkle2 = Icon(
        line = RealVectorRes("Twinkle2.Line", "drawable/ic_dig_twinkle_2_line.xml"),
        fill = RealVectorRes("Twinkle2.Fill", "drawable/ic_dig_twinkle_2_fill.xml"),
        pictogram = null,
        spot = null,
    )

    actual val home: Icon
        get() = TODO("Not yet implemented")
    actual val image: Icon
        get() = TODO("Not yet implemented")
    actual val upgrade: Icon
        get() = TODO("Not yet implemented")
    actual val person: Icon
        get() = TODO("Not yet implemented")

    override fun list() = mutableListOf(
        checkmarkCircle,
        fail,
        twinkle2
    )

    override fun resPaths(): MutableList<MultiplatformRes> {
        val icons = list()
        val resPaths: MutableList<MultiplatformRes> = mutableListOf()

        icons.forEach { icon ->
            resPaths.add(icon.line)
            if (icon.fill != null) resPaths.add(icon.fill!!)
            if (icon.pictogram != null) resPaths.add(icon.pictogram!!)
            if (icon.spot != null) resPaths.add(icon.spot!!)
        }

        return resPaths
    }
}