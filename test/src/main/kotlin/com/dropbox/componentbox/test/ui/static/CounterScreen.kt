package com.dropbox.componentbox.test.ui.static

import com.dropbox.componentbox.Alignment
import com.dropbox.componentbox.Arrangement
import com.dropbox.componentbox.Color
import com.dropbox.componentbox.FontWeight
import com.dropbox.componentbox.SerializableComponentBox
import com.dropbox.componentbox.TextStyle
import com.dropbox.componentbox.column
import com.dropbox.componentbox.componentBox
import com.dropbox.componentbox.dp
import com.dropbox.componentbox.text
import com.dropbox.componentbox.textButton
import com.dropbox.componentbox.tree

@SerializableComponentBox
fun static() = componentBox {
    tree {
        column<CounterEvent>(
            verticalArrangement = Arrangement.SpaceEvenly(2.dp),
            horizontalAlignment = Alignment.Start
        ) {
            child(header)
            child(count)
            child(incrementButton("+1"))
            child(decrementButton("-1"))
        }
    }
}


val header = text(
    text = "Component Box Counter",
    style = TextStyle(fontWeight = FontWeight.ExtraBold)
)

val count = text(
    text = "Count: \${COUNTER_STATE}",
    style = TextStyle(color = Color.Hex("#FF0000"))
)

fun incrementButton(text: String) = textButton(
    text = text
)

fun decrementButton(text: String) = textButton(
    text = text
)