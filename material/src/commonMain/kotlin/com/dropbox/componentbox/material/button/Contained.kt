package com.dropbox.componentbox.material.button

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.util.compose
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.material.Inflate
import com.dropbox.componentbox.util.build

@Composable
fun Component.Button.Contained(context: Context? = null) {
    Button(
        modifier = modifier.build(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = modifier?.background.compose() ?: MaterialTheme.colors.primary,
        ),
        onClick = { context?.manager?.run(action) }
    ) {
        components?.forEach { component ->
            component.Inflate(context)
        }
    }
}