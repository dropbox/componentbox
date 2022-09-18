package com.dropbox.componentbox.repository

import com.dropbox.componentbox.ComponentBox
import kotlinx.coroutines.flow.Flow


interface ComponentBoxRepository<Key : Any> {
    fun read(key: Key): Flow<ComponentBox>
    fun write(key: Key, componentBox: ComponentBox)
}