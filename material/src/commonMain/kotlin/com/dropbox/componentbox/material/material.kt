package com.dropbox.componentbox.material

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.component.Column
import com.dropbox.componentbox.component.Component
import com.dropbox.componentbox.component.ContainedButton
import com.dropbox.componentbox.component.Icon
import com.dropbox.componentbox.component.LazyColumn
import com.dropbox.componentbox.component.LazyRow
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
private fun Component.material(kit: ComponentBoxKit) {
    when (this) {
        is Icon<*> -> icon(kit)
        is LocalImage<*> -> localImage(kit)
        is NetworkImage<*> -> networkImage(kit)
        is Column -> column(kit)
        is Row -> row(kit)
        is Stack -> TODO()
        is ContainedButton -> containedButton(kit)
        is OutlinedButton -> TODO()
        is TextButton -> TODO()
        is Switch -> TODO()
        is Text -> text(kit)
    }
}

@Composable
private fun ContainedButton.containedButton(kit: ComponentBoxKit) {
    if (modifier?.background != null) {
        Button(
            modifier = kit.modifierTransformer(modifier),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = kit.colorTransformer(modifier!!.background!!),
            ),
            onClick = {
                kit.actionHandler(actions?.onClick)
            }
        ) {
            components?.forEach { component ->
                component.material(kit)
            }
        }
    } else {
        Button(
            modifier = kit.modifierTransformer(modifier),
            onClick = {
                kit.actionHandler(actions?.onClick)
            }
        ) {
            components?.forEach { component ->
                component.material(kit)
            }
        }
    }
}

@Composable
private fun <Id : Any> LocalImage<Id>?.localImage(kit: ComponentBoxKit) {
    if (this != null) {
        Image(
            painter = kit.imagePainterConverter(this),
            modifier = kit.modifierTransformer(modifier),
            contentScale = kit.contentScaleTransformer(contentScale),
            contentDescription = contentDescription
        )
    }
}

@Composable
private fun <Id : Any> NetworkImage<Id>?.networkImage(kit: ComponentBoxKit) {
    if (this != null) {
        Image(
            painter = kit.imagePainterConverter(this),
            modifier = kit.modifierTransformer(modifier),
            contentScale = kit.contentScaleTransformer(contentScale),
            contentDescription = contentDescription
        )
    }
}

@Composable
private fun <Id : Any> Icon<Id>?.icon(kit: ComponentBoxKit) {
    if (this != null) {
        if (color != null) {
            Icon(
                painter = kit.iconPainterConverter(this),
                contentDescription = contentDescription,
                modifier = kit.modifierTransformer(modifier),
                tint = kit.colorTransformer(color!!)
            )
        } else {
            Icon(
                painter = kit.iconPainterConverter(this),
                contentDescription = contentDescription,
                modifier = kit.modifierTransformer(modifier),
            )
        }
    }
}

@Composable
private fun Text.text(kit: ComponentBoxKit) {
    if (text != null) {
        val style = kit.textStyler(textStyle)
        if (style != null) {
            if (color != null) {
                Text(
                    text = kit.textProcessor(text!!),
                    style = style,
                    modifier = kit.modifierTransformer(modifier),
                    color = kit.colorTransformer(color!!)
                )
            } else {
                Text(
                    text = kit.textProcessor(text!!),
                    modifier = kit.modifierTransformer(modifier),
                    style = style
                )
            }
        } else {
            if (color != null) {
                Text(
                    text = kit.textProcessor(text!!),
                    modifier = kit.modifierTransformer(modifier),
                    color = kit.colorTransformer(color!!)
                )
            } else {
                Text(
                    text = kit.textProcessor(text!!),
                    modifier = kit.modifierTransformer(modifier),
                )
            }
        }
    }
}


@Composable
private fun Column.column(kit: ComponentBoxKit) {
    when (this) {
        is LazyColumn -> {
            LazyColumn(
                modifier = kit.modifierTransformer(modifier),
                verticalArrangement = kit.verticalArrangementConverter(this.verticalArrangement) ?: Arrangement.Top,
                horizontalAlignment = kit.horizontalAlignmentConverter(this.horizontalAlignment) ?: Alignment.Start
            ) {
                if (components != null) {
                    items(components!!) { component ->
                        component.material(kit)
                    }
                }
            }
        }

        else -> Column(
            modifier = kit.modifierTransformer(modifier),
            verticalArrangement = kit.verticalArrangementConverter(this.verticalArrangement) ?: Arrangement.Top,
            horizontalAlignment = kit.horizontalAlignmentConverter(this.horizontalAlignment) ?: Alignment.Start
        ) {
            components?.forEach { component ->
                component.material(kit)
            }
        }
    }
}

@Composable
private fun Row.row(kit: ComponentBoxKit) {
    when (this) {
        is LazyRow -> {
            LazyRow(
                modifier = kit.modifierTransformer(modifier),
                verticalAlignment = kit.verticalAlignmentConverter(this.verticalAlignment) ?: Alignment.Top,
                horizontalArrangement = kit.horizontalArrangementConverter(this.horizontalArrangement)
                    ?: Arrangement.Start
            ) {
                if (components != null) {
                    items(components!!) { component ->
                        component.material(kit)
                    }
                }
            }
        }

        else -> Row(
            modifier = kit.modifierTransformer(modifier),
            verticalAlignment = kit.verticalAlignmentConverter(this.verticalAlignment) ?: Alignment.Top,
            horizontalArrangement = kit.horizontalArrangementConverter(this.horizontalArrangement)
                ?: Arrangement.Start
        ) {
            components?.forEach { component ->
                component.material(kit)
            }
        }
    }
}