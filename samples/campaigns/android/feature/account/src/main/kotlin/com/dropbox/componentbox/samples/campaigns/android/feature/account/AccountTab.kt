@file:OptIn(ExperimentalCoilApi::class)

package com.dropbox.componentbox.samples.campaigns.android.feature.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@Composable
fun AccountTab(
    viewModel: AccountViewModel = viewModel(),
    campaignsViewModel: AccountTabCampaignsViewModel = AccountTabCampaignsViewModel(),
) {

    LaunchedEffect(campaignsViewModel) {
        println("PRESENTING")
        campaignsViewModel.present()
    }

    val state = viewModel.state.collectAsState()
    val campaignsState = campaignsViewModel.state.collectAsState()



    Column {

        when (val viewState = state.value.viewState) {
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

                Text("Campaigns State - ${campaignsState.value.componentBox.toString()}")

                with(viewState.user) {
                    Text("User", style = MaterialTheme.typography.h5)

                    Text(name)
                    Text(email)

                    val painter = rememberImagePainter(avatarUrl)
                    Image(
                        painter = painter, contentDescription = name, contentScale = ContentScale.Crop, modifier = Modifier
                            .clip(CircleShape)
                            .size(96.dp)
                    )

                }

                with(viewState.plan) {
                    Text("Plan", style = MaterialTheme.typography.h5)
                    Text(name)
                }


                with(viewState.deviceUsage) {
                    Text("Device Usage", style = MaterialTheme.typography.h5)
                    Text("$linkedDevicesCount of $linkedDevicesMax devices linked")
                    linkedDevices.forEach { linkedDevice ->
                        Text("${linkedDevice.name} - ${linkedDevice.platform.name}")
                    }
                }

                with(viewState.spaceUsage) {
                    Text("Space Usage", style = MaterialTheme.typography.h5)
                    Text("$bytesUsed bytes of $bytesTotal bytes used")
                    Text("$percentageUsed %")
                }
            }
        }
    }
}
