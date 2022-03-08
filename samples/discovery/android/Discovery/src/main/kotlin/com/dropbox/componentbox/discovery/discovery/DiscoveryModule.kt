package com.dropbox.componentbox.discovery.discovery

import com.dropbox.componentbox.discovery.discovery.scoping.AppScope
import com.dropbox.componentbox.discovery.discovery.scoping.UserScope
import com.dropbox.componentbox.discovery.discovery.scoping.appScope
import com.dropbox.componentbox.discovery.discovery.scoping.userScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DiscoveryModule {
    @Provides
    @Singleton
    fun provideAppScope(): AppScope = appScope()

    @Provides
    @Singleton
    fun provideUserScope(): UserScope = userScope()
}