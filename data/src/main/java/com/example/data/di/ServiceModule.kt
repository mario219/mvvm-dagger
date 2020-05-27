package com.example.data.di

import com.example.data.service.BlockApi
import com.example.data.service.ServiceFactory
import dagger.Module
import dagger.Provides

@Module
internal class ServiceModule {

    @Provides
    fun providesGistApi(): BlockApi {
        return ServiceFactory.getService(BlockApi::class.java)
    }
}