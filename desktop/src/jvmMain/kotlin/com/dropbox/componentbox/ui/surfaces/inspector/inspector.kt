package com.dropbox.componentbox.ui.surfaces.inspector

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.Themer
import com.dropbox.componentbox.data.entities.Context
import com.dropbox.componentbox.ui.surfaces.inspector.panels.export.exportPanel
import com.dropbox.componentbox.ui.surfaces.inspector.panels.main.mainPanel
import com.dropbox.componentbox.ui.surfaces.inspector.panels.root.rootPanel
import com.dropbox.componentbox.ui.theme.disabledBackground
import com.dropbox.componentbox.ui.theme.inverseStandardBackground
import com.dropbox.componentbox.ui.theme.paperBackground

@Composable
fun inspector(context: Context, themer: Themer) {
    val activeTab = remember { mutableStateOf(0) }

    val panels = listOf(
        Panel("Root", 0),
        Panel("Inspect", 1),
        Panel("Export", 2)
    )

    fun setActiveTab(index: Int) {
        activeTab.value = index
    }

    @Composable
    fun textColor(index: Int): Color {
        return if (index == activeTab.value) {
            MaterialTheme.colors.inverseStandardBackground
        } else MaterialTheme.colors.disabledBackground
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(400.dp)
            .background(color = MaterialTheme.colors.paperBackground)
            .padding(8.dp)
    ) {

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

            LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(panels) { panel ->
                    Text(
                        text = panel.title,
                        color = textColor(panel.index),
                        modifier = Modifier.clickable { setActiveTab(panel.index) })
                }
            }

            Divider(modifier = Modifier.fillMaxWidth().height(2.dp))
        }

        when (activeTab.value) {
            0 -> rootPanel()
            1 -> mainPanel(context, themer)
            2 -> exportPanel()
        }
    }
}

private data class Panel(
    val title: String,
    val index: Int
)