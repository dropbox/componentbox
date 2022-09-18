package com.dropbox.componentbox.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.dropbox.componentbox.viewmodel.ComponentBoxChange
import com.dropbox.componentbox.viewmodel.ComponentBoxViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flow

@Composable
fun <Key : Any> ComponentBox(
    key: Key,
    controller: ComponentBoxController,
    viewModel: ComponentBoxViewModel<Key>,
) {
    LaunchedEffect(key) {
        viewModel.launch(key)
    }

    val viewState = viewModel.componentBox.collectAsState().value
    controller.start(
        viewState = viewState,
        events = viewModel.changes.asFlow(),
        navigation = viewModel.navigation.asFlow()
    )
}


private fun MutableStateFlow<ComponentBoxChange.Navigation>.asFlow() = flow {
    filterIsInstance<ComponentBoxChange.Navigation.Data>().collectLatest { emit(it.value) }
}

private fun MutableStateFlow<ComponentBoxChange>.asFlow() = flow {
    filterIsInstance<ComponentBoxChange.Event.Data>().collectLatest { emit(it.value) }
}