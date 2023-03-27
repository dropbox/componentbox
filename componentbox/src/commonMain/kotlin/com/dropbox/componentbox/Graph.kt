package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable


sealed interface Graph {
    val start: ComponentBoxId
    val componentBoxes: MutableMap<ComponentBoxId, ComponentBox>


    interface Static : Graph {
        fun componentBox(id: ComponentBoxId, componentBox: ComponentBox)
    }

    interface Dynamic : Graph {
        val componentBox: StateFlow<ComponentBox>

        @Composable
        fun componentBox(id: ComponentBoxId, componentBox: ComponentBox)

        fun navigateTo(componentBoxId: ComponentBoxId)
    }
}

@Serializable
class StaticGraph(
    override val start: ComponentBoxId,
    override val componentBoxes: MutableMap<ComponentBoxId, ComponentBox> = mutableMapOf()
) : Graph.Static {
    override fun componentBox(id: ComponentBoxId, componentBox: ComponentBox) {
        componentBoxes[id] = componentBox
    }
}

class DynamicGraph(
    override val start: ComponentBoxId,
    override val componentBoxes: MutableMap<ComponentBoxId, ComponentBox> = mutableMapOf()
) : Graph.Dynamic {

    private val stateFlow = MutableStateFlow(requireNotNull(componentBoxes[start]))
    override val componentBox: StateFlow<ComponentBox> = stateFlow

    @Composable
    override fun componentBox(id: ComponentBoxId, componentBox: ComponentBox) {
        componentBoxes[id] = componentBox
    }

    override fun navigateTo(componentBoxId: ComponentBoxId) {
        val next = componentBoxes[componentBoxId]
        if (next != null) {
            stateFlow.value = next
        }
    }
}