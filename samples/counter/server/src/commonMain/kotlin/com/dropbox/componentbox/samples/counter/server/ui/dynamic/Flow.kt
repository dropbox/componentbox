package com.dropbox.componentbox.samples.counter.server.ui.dynamic

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.ComponentBoxExport
import com.dropbox.componentbox.Trail
import com.dropbox.componentbox.model.statefulComponentBox

@Composable
@ComponentBoxExport
fun statefulOnboardingFlow() = statefulComponentBox<Trail.Dynamic?>(init = null) {
    onboardingFlow()
}


@Composable
fun onboardingFlow() = Trail {
    node(counterScreenUI())
    node(counterScreenUI())
}