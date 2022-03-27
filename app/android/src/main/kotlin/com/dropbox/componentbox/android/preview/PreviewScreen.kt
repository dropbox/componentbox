package com.dropbox.componentbox.android.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.foundation.Inflater
import com.dropbox.componentbox.foundation.Manager
import com.dropbox.componentbox.foundation.ResourceProvider
import com.dropbox.componentbox.foundation.Themer
import com.dropbox.componentbox.material.Inflate
import com.dropbox.componentbox.samples.discovery.RealInflater
import com.dropbox.componentbox.samples.discovery.RealResourceProvider
import com.dropbox.componentbox.samples.discovery.color.Colors
import com.dropbox.componentbox.samples.discovery.type.materialTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import javax.inject.Singleton

@Composable
fun PreviewScreen() {

    val presenter: PreviewPresenter = mavericksViewModel()
    val isRefreshing by presenter.isRefreshing.collectAsState()

    LaunchedEffect(Unit) {
        presenter.pull()
    }

    val state = presenter.collectAsState()
    val screen = presenter.screen.collectAsState()

    fun pull() = runBlocking { presenter.pull() }

    when (screen.value) {
        null -> when (state.value.viewState) {
            PreviewViewState.Failure -> Text(text = "Failure")
            PreviewViewState.Initialized -> Text(text = "Init")
            PreviewViewState.Loading -> Text(text = "Loading")
            PreviewViewState.Success -> {}
        }
        else -> {
            SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing), onRefresh = { pull() }) {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    screen.value!!.Inflate(context = appScope().context)
                }
            }
        }
    }
}

@InstallIn(SingletonComponent::class)
@Module
object PreviewModule {

    @Provides
    @Singleton
    fun provideAppScope(): AppScope = appScope()
}

data class AppScope(
    val inflater: Inflater,
    val resourceProvider: ResourceProvider,
    val context: Context
)

fun appScope() = AppScope(
    inflater = RealInflater(),
    resourceProvider = RealResourceProvider(),
    context = Context(RealInflater(), DiscoveryThemer(), DiscoveryManager())
)

class DiscoveryThemer : Themer() {
    @Composable
    override fun Theme(isNightMode: Boolean, content: () -> Unit) {
        TODO("Not yet implemented")
    }

    @Composable
    override fun getDrawableResId(name: String?): Int? {
        TODO("Not yet implemented")
    }

    @Composable
    override fun getTextStyle(name: String?): TextStyle {
        TODO("Not yet implemented")
    }
}

class DiscoveryManager : Manager {
    override fun run(action: String?) {
        TODO("Not yet implemented")
    }
}

@Composable
fun DiscoveryTheme(isNightMode: Boolean, content: @Composable () -> Unit) {
    val colors = remember { mutableStateOf(if (isNightMode) Colors.Dark else Colors.Light) }
    return MaterialTheme(
        typography = appScope().resourceProvider.typography().materialTheme(),
        colors = colors.value,
        content = content
    )
}