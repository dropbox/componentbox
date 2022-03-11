package com.dropbox.componentbox.ui.surfaces.inspector.panels.export

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.store.state.AppState
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.ui.theme.inverseStandardBackground
import com.dropbox.componentbox.ui.theme.successFill
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Composable
fun exportbutton() {
    var version = 1

    Button(
        onClick = {
            exportJson(store.state, version)
            version += 1
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.successFill,
            contentColor = MaterialTheme.colors.inverseStandardBackground
        )
    ) {
        Text(
            text = BUTTON_LABEL,
            color = MaterialTheme.colors.inverseStandardBackground,
            style = MaterialTheme.typography.button
        )
    }
}

private fun buildScreen(state: AppState) = ComponentBox.Screen(
    title = state.screenState.title,
    verticalArrangement = state.screenState.verticalArrangement,
    horizontalAlignment = state.screenState.horizontalAlignment,
    components = state.componentState.rootComponents
)

private fun exportJson(state: AppState, version: Int) {
    val format = Json { prettyPrint = true }
    val json = format.encodeToString(buildScreen(state))
    val home = System.getProperty("user.home")
    val fileName = "ComponentBox-0.1.0-${state.screenState.id}-${version}"
    File("$home/Downloads/$fileName.json").printWriter().use { it.println(json) }
}

private const val BUTTON_LABEL = "Export"