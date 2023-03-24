package com.dropbox.componentbox.samples.counter

import com.dropbox.componentbox.Alignment
import com.dropbox.componentbox.Arrangement
import com.dropbox.componentbox.Color
import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.FontWeight
import com.dropbox.componentbox.TextStyle
import com.dropbox.componentbox.column
import com.dropbox.componentbox.dp
import com.dropbox.componentbox.text
import com.dropbox.componentbox.textButton

@ComponentBox
object UI {
    private val counter = Counter()

    private val header = text(
            text = "Component Box Counter",
            style = TextStyle(fontWeight = FontWeight.ExtraBold)
    )

    private val count = text(
            text = "Count: ${counter.state.value}",
            style = TextStyle(color = Color.Hex("#FF0000"))
    )

    private val incrementButton = textButton(text = "+1") { counter.on("increment") }
    private val decrementButton = textButton(text = "-1") { counter.on("decrement") }


    val tree = column(
            verticalArrangement = Arrangement.SpaceEvenly(2.dp),
            horizontalAlignment = Alignment.Start
    ) {
        child(header)
        child(count)
        child(incrementButton)
        child(decrementButton)
    }
}

