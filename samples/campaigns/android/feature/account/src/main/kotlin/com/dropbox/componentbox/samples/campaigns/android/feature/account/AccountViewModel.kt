package com.dropbox.componentbox.samples.campaigns.android.feature.account

import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.samples.campaigns.common.viewmodel.ViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


data class AccountState(
    val viewState: AccountViewState = AccountViewState.Initial,
    val dismissibleCampaigns: AccountCampaigns? = null,
    val event: AccountEvent? = null
)


data class AccountCampaigns(
    val banner: StateFlow<ComponentBox?>,
    val modal: StateFlow<ComponentBox?>
)

data class User(
    val name: String,
    val email: String,
    val avatarUrl: String,
)

data class SpaceUsage(
    val bytesUsed: Float,
    val bytesTotal: Float
) {
    val percentageUsed = bytesUsed.div(bytesTotal).times(100f)
}


data class DeviceUsage(
    val linkedDevicesCount: Int,
    val linkedDevicesMax: Int,
    val linkedDevices: List<LinkedDevice>
)

data class LinkedDevice(
    val name: String,
    val platform: Platform
) {
    enum class Platform {
        Android,
        Ios,
        Desktop
    }
}

enum class Plan {
    Basic,
    Plus,
    Family,
    Pro
}

sealed class AccountViewState {
    object Initial : AccountViewState()
    object Loading : AccountViewState()
    object Failure : AccountViewState()
    data class Success(
        val user: User,
        val plan: Plan,
        val spaceUsage: SpaceUsage,
        val deviceUsage: DeviceUsage
    ) : AccountViewState()
}


sealed class AccountEvent {
    sealed class Navigate : AccountEvent() {
        object PurchaseFlow : Navigate()
    }
}

class AccountViewModel(initialState: AccountState = AccountState()) : ViewModel<AccountState, AccountEvent>(initialState) {

    init {
        viewModelScope.launch {
            loadState()
        }
    }

    private suspend fun loadState() {
        val user = fetchUser()
        val plan = fetchPlan()
        val spaceUsage = fetchSpaceUsage()
        val deviceUsage = fetchDeviceUsage()

        withState { state ->
            val viewState = AccountViewState.Success(user, plan, spaceUsage, deviceUsage)
            val nextState = state.copy(viewState = viewState)
            setState(nextState)
        }
    }

    private fun fetchUser(): User = User("Tag", "tag@dropbox.com", "https://i.imgur.com/ALgZy8X.jpg")
    private fun fetchPlan(): Plan = Plan.Basic
    private fun fetchSpaceUsage(): SpaceUsage = SpaceUsage(500f, 2000f)
    private fun fetchDeviceUsage() = DeviceUsage(
        3, 3, listOf(
            LinkedDevice("Tag's M1", LinkedDevice.Platform.Desktop),
            LinkedDevice("Tag's Mac Pro", LinkedDevice.Platform.Desktop),
            LinkedDevice("Tag's iPhone", LinkedDevice.Platform.Ios)
        )
    )

    override fun onEvent(event: AccountEvent) = when (event) {
        AccountEvent.Navigate.PurchaseFlow -> {
            val nextState = state.value.copy(event = event)
            setState(nextState)
        }
    }
}