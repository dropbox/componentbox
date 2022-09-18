package com.dropbox.componentbox.viewmodel

import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.repository.ComponentBoxRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.launch


abstract class ComponentBoxViewModel<Key : Any>(
    private val key: Key,
    private val scope: CoroutineScope,
    private val repository: ComponentBoxRepository<Key>,
) {
    val changes = MutableStateFlow<ComponentBoxChange>(EmptyComponentBoxChange)
    private val data = MutableStateFlow<RawComponentBox>(EmptyRawComponentBox)
    val navigation = MutableStateFlow<ComponentBoxChange.Navigation>(EmptyComponentBoxNavigation)
    val componentBox = MutableStateFlow<ZiplineResponse>(ZiplineResponse.Initial)

    init {
        handleDataChanges()

        scope.launch {
            repository.read(key).collectLatest {
                data.emit(RawComponentBoxData(it))
            }
        }

    }

    private fun handleDataChanges() {
        scope.launch {
            changes.filterIsInstance<ComponentBoxChange.Data.Data<Key>>().collect { change ->
                when (val event = change.value) {
                    is ComponentBox.Event.Data.Read -> repository.read(event.key)
                    is ComponentBox.Event.Data.Write -> repository.write(event.key, event.input)
                }
            }
        }
    }


    abstract fun launch(key: Key)

    abstract fun close()

}