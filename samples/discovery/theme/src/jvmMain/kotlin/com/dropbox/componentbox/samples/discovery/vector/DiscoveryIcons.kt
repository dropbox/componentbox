package com.dropbox.componentbox.samples.discovery.vector

import com.dropbox.componentbox.models.Icon
import com.dropbox.componentbox.models.Icons
import com.dropbox.componentbox.models.MultiplatformRes
import com.dropbox.componentbox.models.RealVectorRes

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