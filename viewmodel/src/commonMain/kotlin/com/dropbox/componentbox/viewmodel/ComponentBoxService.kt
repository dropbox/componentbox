package com.dropbox.componentbox.viewmodel

import app.cash.zipline.ZiplineService
import com.dropbox.componentbox.ComponentBox
import kotlinx.coroutines.flow.Flow

sealed class ZiplineResponse : ComponentBoxViewState {
    object Initial : ComponentBoxViewState.Initial, ZiplineResponse()
    data class Data(override val value: ComponentBox) : ComponentBoxViewState.Data, ZiplineResponse()
}

sealed interface ComponentBoxViewState {
    interface Initial : ComponentBoxViewState
    interface Data : ComponentBoxViewState {
        val value: ComponentBox
    }
}

sealed interface RawComponentBox {
    interface Empty : RawComponentBox
    interface Data : RawComponentBox {
        val value: ComponentBox
    }
}

object EmptyRawComponentBox : RawComponentBox.Empty
data class RawComponentBoxData(override val value: ComponentBox) : RawComponentBox.Data

interface ComponentBoxChange {
    interface Empty : ComponentBoxChange

    sealed interface Event : ComponentBoxChange {
        interface Empty : Event
        interface Data : Event {
            val value: ComponentBox.Event
        }
    }

    sealed interface Navigation : ComponentBoxChange {
        interface Empty : Navigation
        interface Data : Navigation {
            val value: ComponentBox.Navigation
        }
    }

    sealed interface Data : ComponentBoxChange {
        interface Empty : ComponentBoxChange.Data
        interface Data<Key : Any> : ComponentBoxChange.Data {
            val value: ComponentBox.Event.Data<Key>
        }
    }
}


object EmptyComponentBoxNavigation : ComponentBoxChange.Navigation.Empty
object EmptyComponentBoxData : ComponentBoxChange.Data.Empty
object EmptyComponentBoxEvent : ComponentBoxChange.Event.Empty
object EmptyComponentBoxChange : ComponentBoxChange.Empty

interface ComponentBoxPresenter : ZiplineService {
    fun componentBox(data: Flow<ComponentBox>, events: Flow<ComponentBox.Event>): Flow<ZiplineResponse>
    fun navigate(navigation: Flow<ComponentBox.Navigation>)
}