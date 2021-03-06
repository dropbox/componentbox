import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dropbox.componentbox.foundation.Inflater
import com.dropbox.componentbox.foundation.ResourceProvider
import com.dropbox.componentbox.foundation.Themer
import com.dropbox.desktop.componentbox.data.entities.Context
import com.dropbox.desktop.componentbox.store.actions.ThemeAction
import com.dropbox.desktop.componentbox.store.store
import com.dropbox.desktop.componentbox.ui
import com.dropbox.desktop.componentbox.ui.theme.componentBoxTheme

@Composable
fun app(inflater: Inflater, themer: Themer, resourceProvider: ResourceProvider) = MaterialTheme {
    val isNightMode = remember { mutableStateOf(store.state.themeState.isNightMode) }

    fun syncIsNightMode() {
        isNightMode.value = store.state.screenState.isNightMode
    }

    store.dispatch(ThemeAction.SetColors(resourceProvider.colors().list()))
    store.dispatch(ThemeAction.SetBackground(resourceProvider.colors().background))
    store.subscribe { syncIsNightMode() }

    componentBoxTheme {
        themer.Theme(isNightMode.value) {
            ui(Context(resourceProvider), inflater, themer)
        }
    }
}


