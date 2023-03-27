package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable


sealed interface Graph<T : Forest> : ComponentBox {
    val start: String
    val forests: MutableMap<ForestId, T>


    interface Static : Graph<Forest.Static> {
        fun forest(id: ForestId, forest: Forest.Static)
    }

    interface Dynamic : Graph<Forest.Dynamic> {
        val forest: StateFlow<Forest.Dynamic>

        @Composable
        fun forest(id: ForestId, forest: Forest.Dynamic)

        fun navigateTo(forestId: ForestId)
    }
}

@Serializable
data class StaticGraph(
    override val start: ForestId,
    override val forests: MutableMap<ForestId, Forest.Static> = mutableMapOf()
) : Graph.Static {
    override fun forest(id: ForestId, forest: Forest.Static) {
        forests[id] = forest
    }
}

class DynamicGraph(
    override val start: ForestId,
    override val forests: MutableMap<ForestId, Forest.Dynamic> = mutableMapOf()
) : Graph.Dynamic {

    private val stateFlow = MutableStateFlow(requireNotNull(forests[start]))
    override val forest: StateFlow<Forest.Dynamic> = stateFlow

    @Composable
    override fun forest(id: ForestId, forest: Forest.Dynamic) {
        forests[id] = forest
    }

    override fun navigateTo(forestId: ForestId) {
        val next = forests[forestId]
        if (next != null) {
            stateFlow.value = next
        }
    }
}