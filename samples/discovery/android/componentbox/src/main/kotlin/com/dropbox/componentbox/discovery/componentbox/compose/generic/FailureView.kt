package com.dropbox.componentbox.discovery.componentbox.compose.generic

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.discovery.componentbox.compose.modal.ModalFallbackView
import com.dropbox.componentbox.discovery.componentbox.compose.screen.ScreenFallbackView
import com.dropbox.componentbox.discovery.componentbox.compose.ComponentBoxRoot
import com.dropbox.componentbox.discovery.componentbox.compose.banner.BannerFallbackView
import com.dropbox.componentbox.models.ComponentBox

@Composable
inline fun <reified C : ComponentBox> FailureView(
    noinline Custom: (@Composable () -> Unit)? = null,
) {
    ComponentBoxRoot<C>(
        modal = if (Custom != null) ({ Custom() }) else ({ ModalFallbackView() }),
        screen = if (Custom != null) ({ Custom() }) else ({ ScreenFallbackView() }),
        banner = if (Custom != null) ({ Custom() }) else ({ BannerFallbackView() }),
    )
}
