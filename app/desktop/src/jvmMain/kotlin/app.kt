import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dropbox.componentbox.PreviewApi
import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.foundation.Inflater
import com.dropbox.componentbox.foundation.ResourceProvider
import com.dropbox.componentbox.foundation.Themer
import com.dropbox.desktop.componentbox.data.entities.Context
import com.dropbox.desktop.componentbox.store.actions.ThemeAction
import com.dropbox.desktop.componentbox.store.store
import com.dropbox.desktop.componentbox.ui
import com.dropbox.desktop.componentbox.ui.theme.componentBoxTheme
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.IOException
import com.dropbox.componentbox.server.main as startServer

@Composable
fun app(inflater: Inflater, themer: Themer, resourceProvider: ResourceProvider) = MaterialTheme {
    startServer()
    Runtime.getRuntime().exec("emulator @PIXEL_4_API_30")

    val isNightMode = remember { mutableStateOf(store.state.themeState.isNightMode) }

    val api = PreviewApi()

    fun syncIsNightMode() {
        isNightMode.value = store.state.screenState.isNightMode
    }

    fun buildScreen() = ComponentBox.Screen(
        title = store.state.screenState.title,
        verticalArrangement = store.state.screenState.verticalArrangement,
        horizontalAlignment = store.state.screenState.horizontalAlignment,
        components = store.state.componentState.rootComponents
    )

    fun syncServer() {
        api.sync(buildScreen())
    }

    fun syncOutput() {
        val format = Json { prettyPrint = true }
        val json = format.encodeToString(buildScreen())
        val home = System.getProperty("user.home")
        val VERSION = "0.1.0"
        val fileName = "${store.state.screenState.id}.$VERSION.componentbox"

        val componentBoxDirectory = File("$home/Documents/ComponentBox")
        val versionedDirectory = File("$home/Documents/ComponentBox/$VERSION")

        if (!componentBoxDirectory.exists()) {
            componentBoxDirectory.mkdir()
        }

        if (!versionedDirectory.exists()) {
            versionedDirectory.mkdir()
        }

        try {
            File("$home/Documents/ComponentBox/$VERSION/$fileName.json").printWriter().use { it.println(json) }
        } catch (error: IOException) {
            println(error.toString())
        }
    }

    store.dispatch(ThemeAction.SetColors(resourceProvider.colors().list()))
    store.dispatch(ThemeAction.SetBackground(resourceProvider.colors().background))
    store.subscribe {
        syncIsNightMode()
        syncServer()
        syncOutput()
    }

    componentBoxTheme {
        themer.Theme(isNightMode.value) {
            ui(Context(resourceProvider), inflater, themer)
        }
    }
}


