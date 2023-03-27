package com.dropbox.componentbox.samples.counter.server.ui.dynamic

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.ComponentBoxExport
import com.dropbox.componentbox.Graph
import com.dropbox.componentbox.model.statefulComponentBoxGraph
import com.dropbox.componentbox.samples.counter.server.ui.dynamic.ComponentBoxId.CounterLoginScreen
import com.dropbox.componentbox.samples.counter.server.ui.dynamic.ComponentBoxId.CounterOnboardingFlow
import com.dropbox.componentbox.samples.counter.server.ui.dynamic.ComponentBoxId.CounterScreen

@Composable
@ComponentBoxExport
fun graph() = statefulComponentBoxGraph(init = null) {
    Graph(start = CounterOnboardingFlow.value) {
        componentBox(CounterLoginScreen.value, loginScreen())
        componentBox(CounterOnboardingFlow.value, onboardingFlow())
        componentBox(CounterScreen.value, counterScreen())
    }
}