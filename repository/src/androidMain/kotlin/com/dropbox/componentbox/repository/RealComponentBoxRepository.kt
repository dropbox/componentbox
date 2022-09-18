package com.dropbox.componentbox.repository

import com.dropbox.android.external.store4.Store
import com.dropbox.android.external.store4.StoreRequest
import com.dropbox.componentbox.ComponentBox
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class RealComponentBoxRepository(
    private val store: Store<String, ComponentBox>
) : ComponentBoxRepository<String> {
    override fun read(key: String): Flow<ComponentBox> {
        return flow {
            store.stream(StoreRequest.fresh(key)).collect { storeResponse ->
                emit(storeResponse.requireData())
            }
        }
    }

    override fun write(key: String, componentBox: ComponentBox) {
        // TODO(mramotar) https://github.com/MobileNativeFoundation/Store/pull/450
    }
}