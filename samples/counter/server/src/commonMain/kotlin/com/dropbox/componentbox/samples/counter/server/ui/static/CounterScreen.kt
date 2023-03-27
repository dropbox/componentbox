package com.dropbox.componentbox.samples.counter.server.ui.static

import com.dropbox.componentbox.Alignment
import com.dropbox.componentbox.Arrangement
import com.dropbox.componentbox.Color
import com.dropbox.componentbox.FontWeight
import com.dropbox.componentbox.SerializableComponentBox
import com.dropbox.componentbox.TextStyle
import com.dropbox.componentbox.dp
import com.dropbox.componentbox.lazyColumn
import com.dropbox.componentbox.samples.counter.server.model.CounterEvent
import com.dropbox.componentbox.samples.counter.server.model.CounterEvent.Decrement
import com.dropbox.componentbox.samples.counter.server.model.CounterEvent.Increment
import com.dropbox.componentbox.semantic
import com.dropbox.componentbox.text
import com.dropbox.componentbox.textButton
import com.dropbox.componentbox.tree

@SerializableComponentBox
val static = tree {
    lazyColumn<CounterEvent>(
        verticalArrangement = Arrangement.SpaceEvenly(2.dp),
        horizontalAlignment = Alignment.Start
    ) {
        child(header)
        child(count)
        child(incrementButton)
        child(decrementButton)
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

val incrementButton = textButton(
    text = "+1",
    onClick = semantic { Increment }
)

val decrementButton = textButton(
    text = "-1",
    onClick = semantic { Decrement }
)