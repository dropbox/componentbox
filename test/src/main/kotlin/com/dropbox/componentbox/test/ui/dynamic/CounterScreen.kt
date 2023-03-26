package com.dropbox.componentbox.test.ui.dynamic

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.Alignment
import com.dropbox.componentbox.Arrangement
import com.dropbox.componentbox.Color
import com.dropbox.componentbox.Column
import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.ComponentBoxExport
import com.dropbox.componentbox.TextStyle
import com.dropbox.componentbox.Tree
import com.dropbox.componentbox.dp
import com.dropbox.componentbox.model.StatefulComponentBox
import com.dropbox.componentbox.model.StatefulComposable
import com.dropbox.componentbox.test.model.Counter
import com.dropbox.componentbox.test.ui.static.CounterEvent.Decrement
import com.dropbox.componentbox.test.ui.static.CounterEvent.Increment
import com.dropbox.componentbox.test.ui.static.header
import com.dropbox.componentbox.test.ui.static.static
import com.dropbox.componentbox.text
import com.dropbox.componentbox.textButton


@Composable
@ComponentBoxExport
fun dynamic() = StatefulComponentBox(default = static()) {
    ComponentBox {
        Tree {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly(2.dp),
                horizontalAlignment = Alignment.Start
            ) {
                child(header)
                child(Count())
                child(IncrementButton("+1"))
                child(DecrementButton("-1"))
            }
        }
    }
}

@Composable
fun IncrementButton(text: String) = StatefulComposable<Counter> {
    textButton(text = text) { it.on(Increment) }
}

@Composable
fun DecrementButton(text: String) = StatefulComposable<Counter> {
    textButton(text = text) { it.on(Decrement) }
}

@Composable
fun Count() = StatefulComposable<Counter> {
    text(
        text = "Count: ${it.state.value}",
        style = TextStyle(color = Color.Hex("#FF0000"))
    )
}
