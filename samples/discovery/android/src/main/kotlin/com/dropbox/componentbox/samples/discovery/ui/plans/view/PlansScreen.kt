package com.dropbox.componentbox.samples.discovery.ui.plans.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.dropbox.componentbox.Inflater
import com.dropbox.componentbox.horizontal
import com.dropbox.componentbox.samples.discovery.ui.plans.presentation.PlansScreenPresenter
import com.dropbox.componentbox.samples.discovery.ui.scaffold.ScaffoldCallback
import com.dropbox.componentbox.vertical

@Composable
fun PlansScreen(inflater: Inflater, callback: ScaffoldCallback) {
    val presenter: PlansScreenPresenter = hiltViewModel()
    val modelsState = presenter.models.collectAsState()
    callback.setTitle(modelsState.value.screen.title.toString())

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = modelsState.value.screen.verticalArrangement.vertical(),
        horizontalAlignment = modelsState.value.screen.horizontalAlignment.horizontal()
    ) {
        modelsState.value.screen.components.forEach { component ->
            inflater.Inflate(component)
        }
    }
}

