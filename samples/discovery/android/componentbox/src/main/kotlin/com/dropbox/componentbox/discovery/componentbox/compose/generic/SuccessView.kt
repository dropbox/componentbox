@file:Suppress("UNCHECKED_CAST")

package com.dropbox.componentbox.discovery.componentbox.compose.generic

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.discovery.componentbox.compose.ComponentBoxRoot
import com.dropbox.componentbox.discovery.componentbox.compose.banner.BannerSuccessView
import com.dropbox.componentbox.discovery.componentbox.compose.modal.ModalSuccessView
import com.dropbox.componentbox.discovery.componentbox.compose.screen.ScreenSuccessView
import com.dropbox.componentbox.discovery.zipline.ComponentBoxModalViewModel
import com.dropbox.componentbox.discovery.zipline.ComponentBoxScreenViewModel
import com.dropbox.componentbox.models.ComponentBox

@Composable
inline fun <reified C : ComponentBox> SuccessView(
    viewModel: Any?,
    noinline Custom: (@Composable () -> Unit)? = null,
) {
    ComponentBoxRoot<C>(
        modal = if (Custom != null) ({ Custom() }) else ({ ModalSuccessView(viewModel as ComponentBoxModalViewModel) }),
        screen = if (Custom != null) ({ Custom() }) else ({ ScreenSuccessView(viewModel as ComponentBoxScreenViewModel) }),
        banner = if (Custom != null) ({ Custom() }) else ({ BannerSuccessView() }),
    )
}
