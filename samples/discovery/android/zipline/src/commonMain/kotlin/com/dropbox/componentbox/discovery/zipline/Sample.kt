package com.dropbox.componentbox.discovery.zipline

import com.dropbox.componentbox.models.Alignment
import com.dropbox.componentbox.models.Arrangement
import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.models.ComponentBox

object Sample {
    private const val TITLE = "Discovery"
    private val verticalArrangement = Arrangement.SpaceBetween
    private val horizontalAlignment = Alignment.CenterHorizontally
    private val components: List<Component> = listOf(
        Component.Box("1"),
        Component.Column("2"),
        Component.Row("3"),
    )
    private val screen = ComponentBox.Screen(TITLE, verticalArrangement, horizontalAlignment, components)

    val viewModel = ComponentBoxScreenViewModel(screen)
}