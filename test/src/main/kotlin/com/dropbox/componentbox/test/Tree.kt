package com.dropbox.componentbox.test

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.Alignment
import com.dropbox.componentbox.Arrangement
import com.dropbox.componentbox.Color
import com.dropbox.componentbox.Component
import com.dropbox.componentbox.FontWeight
import com.dropbox.componentbox.TextStyle
import com.dropbox.componentbox.Tree
import com.dropbox.componentbox.column
import com.dropbox.componentbox.dp
import com.dropbox.componentbox.model.StatefulComponentBox
import com.dropbox.componentbox.model.StatefulComposable
import com.dropbox.componentbox.text
import com.dropbox.componentbox.textButton

@Composable
fun export() {
    StatefulComponentBox {
        object : Tree {
            override val root: Component
                @Composable
                get() = column(
                    verticalArrangement = Arrangement.SpaceEvenly(2.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    child(header)
                    child(Count())
                    child(IncrementButton(text = "+1"))
                    child(DecrementButton(text = "-1"))
                }
        }
    }
}


@Composable
fun IncrementButton(text: String) = StatefulComposable<Counter> {
    textButton(text = text) { it.on("increment") }
}

@Composable
fun DecrementButton(text: String) = StatefulComposable<Counter> {
    textButton(text = text) { it.on("decrement") }
}

val header = text(
    text = "Component Box Counter",
    style = TextStyle(fontWeight = FontWeight.ExtraBold)
)

@Composable
fun Count() = StatefulComposable<Counter> {
    text(
        text = "Count: ${it.state.value}",
        style = TextStyle(color = Color.Hex("#FF0000"))
    )
}
