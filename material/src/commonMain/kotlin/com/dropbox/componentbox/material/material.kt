package com.dropbox.componentbox.material

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.component.Column
import com.dropbox.componentbox.component.Component
import com.dropbox.componentbox.component.ContainedButton
import com.dropbox.componentbox.component.Icon
import com.dropbox.componentbox.component.LocalImage
import com.dropbox.componentbox.component.NetworkImage
import com.dropbox.componentbox.component.OutlinedButton
import com.dropbox.componentbox.component.Row
import com.dropbox.componentbox.component.Stack
import com.dropbox.componentbox.component.Switch
import com.dropbox.componentbox.component.Text
import com.dropbox.componentbox.component.TextButton
import com.dropbox.componentbox.ui.ComponentBoxKit

@Composable
fun ComponentBox.material(kit: ComponentBoxKit) = root.material(kit)

@Composable
internal fun Component.material(kit: ComponentBoxKit) {
    when (this) {
        is Icon<*> -> icon(kit)
        is LocalImage<*> -> localImage(kit)
        is NetworkImage<*> -> networkImage(kit)
        is Column -> column(kit)
        is Row -> row(kit)
        is Stack -> stack(kit)
        is ContainedButton -> containedButton(kit)
        is OutlinedButton -> outlinedButton(kit)
        is TextButton -> textButton(kit)
        is Switch -> switch(kit)
        is Text -> text(kit)
    }
}