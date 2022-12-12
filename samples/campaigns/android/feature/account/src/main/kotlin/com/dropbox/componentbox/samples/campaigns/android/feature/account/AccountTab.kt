package com.dropbox.componentbox.samples.campaigns.android.feature.account

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AccountTab(viewModel: AccountViewModel = viewModel()) {

    val state = viewModel.state.collectAsState()

    when (state.value.viewState) {
        AccountViewState.Failure -> {
            Text("Account Tab - Failure")
        }

        AccountViewState.Initial -> {
            Text("Account Tab - Initial")
        }

        AccountViewState.Loading -> {
            Text("Account Tab - Loading")
        }

        is AccountViewState.Success -> {
            Text("Account Tab - Success")
        }
    }
}
