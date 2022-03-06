package com.dropbox.componentbox.discovery.componentbox.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.DialogFragment
import com.dropbox.componentbox.discovery.componentbox.compose.modal.ComponentBoxModal

abstract class ComponentBoxDialogFragment(
    private val componentBoxId: String,
    private val CustomLoading: (@Composable () -> Unit)? = null,
    private val CustomSuccess: (@Composable () -> Unit)? = null,
    private val CustomFallback: (@Composable () -> Unit)? = null,
) : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ComponentBoxModal(componentBoxId, CustomLoading, CustomSuccess, CustomFallback)
            }
        }
    }
}
