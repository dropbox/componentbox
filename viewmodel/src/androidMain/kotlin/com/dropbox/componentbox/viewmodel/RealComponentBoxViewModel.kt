package com.dropbox.componentbox.viewmodel

import app.cash.zipline.loader.ManifestVerifier.Companion.NO_SIGNATURE_CHECKS
import app.cash.zipline.loader.ZiplineLoader
import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.repository.ComponentBoxRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import java.util.concurrent.Executors


class RealComponentBoxViewModel<Key : Any>(
    private val key: Key,
    private val scope: CoroutineScope,
    private val repository: ComponentBoxRepository<Key>
) {
    private val ziplineExecutorService = Executors.newSingleThreadExecutor { Thread(it, "Zipline") }
    private val ziplineDispatcher = ziplineExecutorService.asCoroutineDispatcher()
    private val okHttpClient = OkHttpClient()
    private val ziplineLoader = ZiplineLoader(ziplineDispatcher, NO_SIGNATURE_CHECKS, okHttpClient)


    val changes = MutableStateFlow<ComponentBoxChange>(EmptyComponentBoxChange)
    val data = MutableStateFlow<RawComponentBox>(EmptyRawComponentBox)
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


    fun launch(manifestUrl: String) {
        launchComponentBoxZipline(
            scope = scope,
            ziplineDispatcher = ziplineDispatcher,
            ziplineLoader = ziplineLoader,
            manifestUrl = manifestUrl,
            data = flow {
                data.filterIsInstance<RawComponentBox.Data>().collectLatest {
                    emit(it.value)
                }
            },
            events = flow {
                changes.filterIsInstance<ComponentBoxChange.Event.Data>().collectLatest {
                    emit(it.value)
                }
            },
            navigation = flow {
                navigation.filterIsInstance<ComponentBoxChange.Navigation.Data>().collectLatest {
                    emit(it.value)
                }
            },
            componentBox = componentBox
        )
    }

    fun close() {
        ziplineExecutorService.shutdown()
    }

}
