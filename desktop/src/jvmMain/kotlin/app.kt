import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dropbox.componentbox.Inflater
import com.dropbox.componentbox.ResourceProvider
import com.dropbox.componentbox.Themer
import com.dropbox.componentbox.data.entities.Context
import com.dropbox.componentbox.store.actions.ThemeAction
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.ui
import com.dropbox.componentbox.ui.theme.componentBoxTheme

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


