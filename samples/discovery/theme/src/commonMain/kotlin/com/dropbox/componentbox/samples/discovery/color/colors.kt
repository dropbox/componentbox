package com.dropbox.componentbox.samples.discovery.color

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.Colors as MaterialColors
import androidx.compose.ui.graphics.Color as ComposeColor
import com.dropbox.componentbox.models.Color as ComponentBoxColor
import com.dropbox.componentbox.models.Colors as ComponentBoxColors

object DiscoveryColors : ComponentBoxColors {
    override val primary =
        ComponentBoxColor(
            title = "Primary",
            light = 0xFF0061FE,
            dark = 0xFF3984FF
        )

    override val primaryVariant =
        ComponentBoxColor(
            title = "Primary variant",
            light = 0x663984FF,
            dark = 0x290061FE
        )

    override val secondary =
        ComponentBoxColor(
            title = "Secondary",
            light = 0xFFF7F5F2,
            dark = 0xFF1E1918
        )

    override val secondaryVariant =
        ComponentBoxColor(title = "Secondary variant", light = 0x33A69171, dark = 0x33BABABA)
    override val background = ComponentBoxColor(title = "Background", light = 0xFFFFFFFF, dark = 0xFF161313)
    override val surface = ComponentBoxColor(title = "Surface", light = 0xFFFBFAF9, dark = 0xFF2B2929)
    override val error = ComponentBoxColor(title = "Error", light = 0xFF9B0032, dark = 0xFFFA551E)
    override val onPrimary = ComponentBoxColor(title = "On primary", light = 0xFFF7F5F2, dark = 0xFF1E1917)
    override val onSecondary = ComponentBoxColor(title = "On secondary", light = 0xFF1E1919, dark = 0xFFF7F5F7)
    override val onBackground = ComponentBoxColor(title = "On background", light = 0xFF1E1919, dark = 0xFFFFFFFF)
    override val onSurface = ComponentBoxColor(title = "On surface", light = 0xFF2B2929, dark = 0xFFFBFAF9)
    override val onError = ComponentBoxColor(title = "On error", light = 0xFFF7F5F2, dark = 0xFF1E1915)
    val disabledBackground = ComponentBoxColor(title = "Disabled background", light = 0xFFC0BBB4, dark = 0xFFD8D3CB)
    val standardBackgroundElevated =
        ComponentBoxColor(title = "Standard background elevated", light = 0xFFFBFAF9, dark = 0xFF2B2929)
    val successFill = ComponentBoxColor(title = "Success fill", light = 0xFFB4DC19, dark = 0xFFB4DC19)
    val faintText = ComponentBoxColor(title = "Faint text", light = 0xC7524A3E, dark = 0x99F7F5F6)
    val standardText = ComponentBoxColor(title = "Standard text", light = 0xFF1E1919, dark = 0xFFF7F5F9)

    override fun list() = mutableListOf(
        primary,
        primaryVariant,
        secondary,
        secondaryVariant,
        background,
        surface,
        error,
        onPrimary,
        onSecondary,
        onBackground,
        onSurface,
        onError,
        disabledBackground,
        standardBackgroundElevated,
        successFill,
        faintText,
        standardText
    )
}

object Colors {
    val Light = MaterialColors(
        primary = ComposeColor(DiscoveryColors.primary.light),
        primaryVariant = ComposeColor(DiscoveryColors.primaryVariant.light),
        secondary = ComposeColor(DiscoveryColors.secondary.light),
        secondaryVariant = ComposeColor(DiscoveryColors.secondaryVariant.light),
        background = ComposeColor(DiscoveryColors.background.light),
        surface = ComposeColor(DiscoveryColors.surface.light),
        error = ComposeColor(DiscoveryColors.error.light),
        onPrimary = ComposeColor(DiscoveryColors.onPrimary.light),
        onSecondary = ComposeColor(DiscoveryColors.onSecondary.light),
        onBackground = ComposeColor(DiscoveryColors.onBackground.light),
        onSurface = ComposeColor(DiscoveryColors.onSurface.light),
        onError = ComposeColor(DiscoveryColors.onError.light),
        isLight = true,
    )

    val Dark = MaterialColors(
        primary = ComposeColor(DiscoveryColors.primary.dark),
        primaryVariant = ComposeColor(DiscoveryColors.primaryVariant.dark),
        secondary = ComposeColor(DiscoveryColors.secondary.dark),
        secondaryVariant = ComposeColor(DiscoveryColors.secondaryVariant.dark),
        background = ComposeColor(DiscoveryColors.background.dark),
        surface = ComposeColor(DiscoveryColors.surface.dark),
        error = ComposeColor(DiscoveryColors.error.dark),
        onPrimary = ComposeColor(DiscoveryColors.onPrimary.dark),
        onSecondary = ComposeColor(DiscoveryColors.onSecondary.dark),
        onBackground = ComposeColor(DiscoveryColors.onBackground.dark),
        onSurface = ComposeColor(DiscoveryColors.onSurface.dark),
        onError = ComposeColor(DiscoveryColors.onError.dark),
        isLight = false,
    )
}

val MaterialColors.disabledBackground: ComposeColor
    @Composable
    get() = if (isLight) ComposeColor(DiscoveryColors.disabledBackground.light) else ComposeColor(DiscoveryColors.disabledBackground.dark)

val MaterialColors.standardBackgroundElevated: ComposeColor
    @Composable
    get() = if (isLight) ComposeColor(DiscoveryColors.standardBackgroundElevated.light) else ComposeColor(
        DiscoveryColors.standardBackgroundElevated.dark
    )

val MaterialColors.successFill: ComposeColor
    @Composable
    get() = if (isLight) ComposeColor(DiscoveryColors.successFill.light) else ComposeColor(DiscoveryColors.successFill.dark)

val MaterialColors.faintText: ComposeColor
    @Composable
    get() = if (isLight) ComposeColor(DiscoveryColors.faintText.light) else ComposeColor(DiscoveryColors.faintText.dark)

val MaterialColors.standardText: ComposeColor
    @Composable
    get() = if (isLight) ComposeColor(DiscoveryColors.standardText.light) else ComposeColor(DiscoveryColors.standardText.dark)

fun String?.discoveryColor() = when (this) {
    DiscoveryColors.primary.title -> DiscoveryColors.primary
    DiscoveryColors.primaryVariant.title -> DiscoveryColors.primaryVariant
    DiscoveryColors.secondary.title -> DiscoveryColors.secondary
    DiscoveryColors.secondaryVariant.title -> DiscoveryColors.secondaryVariant
    DiscoveryColors.background.title -> DiscoveryColors.background
    DiscoveryColors.surface.title -> DiscoveryColors.surface
    DiscoveryColors.error.title -> DiscoveryColors.error
    DiscoveryColors.onPrimary.title -> DiscoveryColors.onPrimary
    DiscoveryColors.onSecondary.title -> DiscoveryColors.onSecondary
    DiscoveryColors.onBackground.title -> DiscoveryColors.onBackground
    DiscoveryColors.onSurface.title -> DiscoveryColors.onSurface
    DiscoveryColors.onError.title -> DiscoveryColors.onError
    DiscoveryColors.disabledBackground.title -> DiscoveryColors.disabledBackground
    DiscoveryColors.standardBackgroundElevated.title -> DiscoveryColors.standardBackgroundElevated
    DiscoveryColors.successFill.title -> DiscoveryColors.successFill
    DiscoveryColors.faintText.title -> DiscoveryColors.faintText
    DiscoveryColors.standardText.title -> DiscoveryColors.standardText
    else -> DiscoveryColors.standardText
}

@Composable
fun ComponentBoxColor.color() = when (this) {
    DiscoveryColors.primary -> MaterialTheme.colors.primary
    DiscoveryColors.primaryVariant -> MaterialTheme.colors.primaryVariant
    DiscoveryColors.secondary -> MaterialTheme.colors.secondary
    DiscoveryColors.secondaryVariant -> MaterialTheme.colors.secondaryVariant
    DiscoveryColors.background -> MaterialTheme.colors.background
    DiscoveryColors.surface -> MaterialTheme.colors.surface
    DiscoveryColors.error -> MaterialTheme.colors.error
    DiscoveryColors.onPrimary -> MaterialTheme.colors.onPrimary
    DiscoveryColors.onSecondary -> MaterialTheme.colors.onSecondary
    DiscoveryColors.onBackground -> MaterialTheme.colors.onBackground
    DiscoveryColors.onSurface -> MaterialTheme.colors.onSurface
    DiscoveryColors.onError -> MaterialTheme.colors.onError
    DiscoveryColors.disabledBackground -> MaterialTheme.colors.disabledBackground
    DiscoveryColors.standardBackgroundElevated -> MaterialTheme.colors.standardBackgroundElevated
    DiscoveryColors.successFill -> MaterialTheme.colors.successFill
    DiscoveryColors.faintText -> MaterialTheme.colors.faintText
    DiscoveryColors.standardText -> MaterialTheme.colors.standardText
    else -> MaterialTheme.colors.standardText
}

