package com.dropbox.componentbox.discovery.componentbox.compose.modal

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.discovery.componentbox.compose.ComponentBoxView
import com.dropbox.componentbox.models.ComponentBox

@Composable
fun ComponentBoxModal(
    id: String,
    CustomLoading: (@Composable () -> Unit)? = null,
    CustomSuccess: (@Composable () -> Unit)? = null,
    CustomFallback: (@Composable () -> Unit)? = null,
) {
    ComponentBoxView<ComponentBox.Modal>(
        id = id,
        CustomLoading = CustomLoading,
        CustomSuccess = CustomSuccess,
        CustomFallback = CustomFallback
    )
}
