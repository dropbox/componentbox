package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable


sealed interface Graph : ComponentBox {
    @Serializable
    data class Static(
        val start: ForestId,
        val forests: MutableMap<ForestId, Forest.Static> = mutableMapOf()
    ) : Graph {
        fun forest(id: ForestId, forest: Forest.Static) {
            forests[id] = forest
        }

        fun get(id: ForestId): Forest.Static? = forests[id]
        fun remove(id: ForestId) = forests.remove(id)
    }

    data class Dynamic(
        val start: ForestId,
        private val forests: MutableMap<ForestId, Forest.Dynamic> = mutableMapOf()
    ) : Graph {

        private val stateFlow = MutableStateFlow(requireNotNull(forests[start]))
        val forest: StateFlow<Forest.Dynamic> = stateFlow

        @Composable
        fun forest(id: ForestId, forest: Forest.Dynamic) {
            forests[id] = forest
        }

        fun get(id: ForestId): Forest.Dynamic? = forests[id]
        fun remove(id: ForestId) = forests.remove(id)

        fun navigateTo(forestId: ForestId) {
            val next = forests[forestId]
            if (next != null) {
                stateFlow.value = next
            }
        }

    }
}