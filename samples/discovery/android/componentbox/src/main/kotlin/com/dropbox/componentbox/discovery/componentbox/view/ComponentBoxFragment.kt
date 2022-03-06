package com.dropbox.componentbox.discovery.componentbox.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.dropbox.componentbox.discovery.componentbox.compose.screen.ComponentBoxScreen

abstract class ComponentBoxFragment(
    private val componentBoxId: String,
    private val CustomLoading: (@Composable () -> Unit)? = null,
    private val CustomSuccess: (@Composable () -> Unit)? = null,
    private val CustomFallback: (@Composable () -> Unit)? = null,
) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ComponentBoxScreen(componentBoxId, CustomLoading, CustomSuccess, CustomFallback)
            }
        }
    }
}
