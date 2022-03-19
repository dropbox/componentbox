package com.dropbox.componentbox.material.drawable

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Context

@Composable
expect fun Component.Drawable.Inflate(context: Context?)
