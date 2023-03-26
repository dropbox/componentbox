package com.dropbox.componentbox.model

interface EventController<Id : Any> {
    fun on(id: Id)
}