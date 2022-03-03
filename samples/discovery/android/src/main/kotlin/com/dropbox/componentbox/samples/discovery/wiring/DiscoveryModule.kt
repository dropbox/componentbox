package com.dropbox.componentbox.samples.discovery.wiring

import com.dropbox.componentbox.samples.discovery.DiscoveryZipline
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
    fun provideZipline(): DiscoveryZipline = DiscoveryZipline()
}
