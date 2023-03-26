package com.dropbox.componentbox.test.model

import com.dropbox.componentbox.model.ComposableModel
import com.dropbox.componentbox.test.ui.static.CounterEvent

class Counter : ComposableModel<Int, CounterEvent>(0) {
    private fun increment() {
        withState {
            setState(state.value + 1)
        }
    }

    private fun decrement() {
        withState {
            setState(state.value - 1)
        }
    }

    override fun on(event: CounterEvent) = when (event) {
        CounterEvent.Increment -> increment()
        CounterEvent.Decrement -> decrement()
    }
}