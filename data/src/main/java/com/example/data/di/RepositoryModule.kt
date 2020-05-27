package com.example.data.di

import com.example.data.repository.BlockInfoRepositoryImpl
import com.example.data.repository.BlockRepositoryImpl
import com.example.domain.repository.BlockInfoRepository
import com.example.domain.repository.BlockRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [DataSourceModule::class])
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun providesBlockInfoRepository(blockInfoRepository: BlockInfoRepositoryImpl): BlockInfoRepository

    @Singleton
    @Binds
    abstract fun providesBlockRepository(blockRepository: BlockRepositoryImpl): BlockRepository
}