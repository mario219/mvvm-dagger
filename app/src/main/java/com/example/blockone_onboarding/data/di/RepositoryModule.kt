package com.example.blockone_onboarding.data.di

import com.example.blockone_onboarding.data.repository.BlockInfoRepositoryImpl
import com.example.blockone_onboarding.data.repository.BlockRepositoryImpl
import com.example.blockone_onboarding.domain.repository.BlockInfoRepository
import com.example.blockone_onboarding.domain.repository.BlockRepository
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