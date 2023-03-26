package com.dropbox.componentbox

import androidx.compose.runtime.Composable

sealed interface ComponentBox {
    interface Static {
        val root: Tree
    }

    interface Dynamic {
        val root: Tree
            @Composable get
    }
}