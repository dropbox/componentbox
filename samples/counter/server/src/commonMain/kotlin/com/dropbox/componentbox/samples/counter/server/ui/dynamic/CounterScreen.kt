package com.dropbox.componentbox.samples.counter.server.ui.dynamic

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.Alignment
import com.dropbox.componentbox.Arrangement
import com.dropbox.componentbox.Color
import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.ComponentBoxExport
import com.dropbox.componentbox.ContainedButton
import com.dropbox.componentbox.LazyColumn
import com.dropbox.componentbox.TextStyle
import com.dropbox.componentbox.Tree
import com.dropbox.componentbox.dp
import com.dropbox.componentbox.lambda
import com.dropbox.componentbox.model.StatefulComposable
import com.dropbox.componentbox.model.statefulComponentBox
import com.dropbox.componentbox.samples.counter.server.model.Counter
import com.dropbox.componentbox.samples.counter.server.model.CounterEvent
import com.dropbox.componentbox.samples.counter.server.model.CounterEvent.*
import com.dropbox.componentbox.samples.counter.server.ui.static.header
import com.dropbox.componentbox.samples.counter.server.ui.static.static
import com.dropbox.componentbox.text


@Composable
@ComponentBoxExport
fun dynamic() = statefulComponentBox(init = static) {
    ComponentBox {
        Tree {
            LazyColumn(
                verticalArrangement = Arrangement.SpaceEvenly(2.dp),
                horizontalAlignment = Alignment.Start
            ) {
                child(header)
                child(Count())
                child(IncrementButton())
                child(DecrementButton())
            }
        }
    }
}

@Composable
fun IncrementButton() = StatefulComposable<Counter> {
    ContainedButton(onClick = lambda { it.on(Increment) }) {
        text(text = "+1")
    }
}

@Composable
fun DecrementButton() = StatefulComposable<Counter> {
    ContainedButton(onClick = lambda { it.on(Decrement) }) {
        text(text = "-1")
    }
}

@Composable
fun Count() = StatefulComposable<Counter> {
    text(
        text = "Count: ${it.state.value}",
        style = TextStyle(color = Color.Hex("#FF0000"))
    )
}
