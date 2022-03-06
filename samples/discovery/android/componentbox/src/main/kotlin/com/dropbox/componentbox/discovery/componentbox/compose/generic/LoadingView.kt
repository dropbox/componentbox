package com.dropbox.common.componentbox.ui.compose.generic

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.discovery.componentbox.compose.modal.ModalLoadingView
import com.dropbox.componentbox.discovery.componentbox.compose.screen.ScreenLoadingView
import com.dropbox.componentbox.discovery.componentbox.compose.ComponentBoxRoot
import com.dropbox.componentbox.discovery.componentbox.compose.banner.BannerLoadingView
import com.dropbox.componentbox.models.ComponentBox

@Composable
inline fun <reified C : ComponentBox> LoadingView(
    noinline Custom: (@Composable () -> Unit)? = null,
) {
    ComponentBoxRoot<C>(
        modal = if (Custom != null) ({ Custom() }) else ({ ModalLoadingView() }),
        screen = if (Custom != null) ({ Custom() }) else ({ ScreenLoadingView() }),
        banner = if (Custom != null) ({ Custom() }) else ({ BannerLoadingView() }),
    )
}
