@file:Suppress("UNCHECKED_CAST")

package com.dropbox.componentbox.campaigns.android.common.binding

import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext

inline fun <reified VM : MavericksViewModel<S>, S : MavericksState> daggerMavericksViewModelFactory() =
    DaggerMavericksViewModelFactory<VM, S>(VM::class.java)

class DaggerMavericksViewModelFactory<VM : MavericksViewModel<S>, S : MavericksState>(
    private val viewModelClass: Class<VM>
) : MavericksViewModelFactory<VM, S> {

    override fun create(viewModelContext: ViewModelContext, state: S): VM {
        val bindings: DaggerMavericksBindings = when (viewModelContext) {
            is FragmentViewModelContext -> viewModelContext.fragment.bindings()
            else -> viewModelContext.activity.bindings()
        }
        val viewModelFactoryMap = bindings.viewModelFactories()
        val viewModelFactory = viewModelFactoryMap[viewModelClass]
            ?: error("Cannot find ViewModelFactory for ${viewModelClass.name}.")

        val castedViewModelFactory = viewModelFactory as? AssistedViewModelFactory<VM, S>
        val viewModel = castedViewModelFactory?.create(state)
        return viewModel as VM
    }
}

interface DaggerMavericksBindings {
    fun viewModelFactories(): Map<Class<out MavericksViewModel<*>>, AssistedViewModelFactory<*, *>>
}
