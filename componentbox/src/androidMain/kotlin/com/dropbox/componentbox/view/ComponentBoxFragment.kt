package com.dropbox.componentbox.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.DialogFragment
import com.dropbox.componentbox.compose.ComponentBoxView
import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.presentation.ComponentBoxPresenter
import com.dropbox.componentbox.presentation.ComponentBoxState
import com.dropbox.componentbox.presentation.ComponentBoxViewModel

abstract class ComponentBoxFragment(
    private val componentBoxUrl: String,
    private val componentBoxPresenter: ComponentBoxPresenter<ComponentBox.Screen, ComponentBoxState, ComponentBoxViewModel<ComponentBox.Screen>>,
    private val componentBoxContext: Context,
    private val Loading: (@Composable () -> Unit),
    private val Fallback: (@Composable () -> Unit)
) : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
                componentBoxContext.themer?.Theme(isSystemInDarkTheme()) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        ComponentBoxView(componentBoxUrl, componentBoxPresenter, componentBoxContext, Loading, Fallback)
                    }
                }
            }
        }
    }
}
