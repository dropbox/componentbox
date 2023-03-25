package com.dropbox.componentbox.plugin.test

import com.dropbox.componentbox.ComposableModel

class Counter : ComposableModel<Int, String>(0) {
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

    override fun on(event: String) = when (event) {
        "increment" -> increment()
        "decrement" -> decrement()
        else -> {}
    }
}