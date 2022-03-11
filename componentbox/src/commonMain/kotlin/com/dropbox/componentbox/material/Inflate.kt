package com.dropbox.componentbox.material

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Context

@Composable
expect fun Component.Inflate(context: Context? = null)