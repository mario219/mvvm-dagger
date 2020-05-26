package com.example.data.di

import com.example.data.datasource.BlockInfoLocalDataSourceImpl
import com.example.data.datasource.BlockInfoRemoteDataSourceImpl
import com.example.data.datasource.BlockLocalDataSourceImpl
import com.example.data.datasource.BlockRemoteDataSourceImpl
import com.example.domain.datasource.BlockInfoLocalDataSource
import com.example.domain.datasource.BlockInfoRemoteDataSource
import com.example.domain.datasource.BlockLocalDataSource
import com.example.domain.datasource.BlockRemoteDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [MappersModule::class, ServiceModule::class, PersistenceModule::class])
internal abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun providesBlockInfoRemoteDataSource(
        blockInfoRemoteDataSourceImpl: BlockInfoRemoteDataSourceImpl
    ): BlockInfoRemoteDataSource

    @Binds
    @Singleton
    abstract fun providesBlockInfoLocalDataSource(
        blockInfoLocalDataSourceImpl: BlockInfoLocalDataSourceImpl
    ): BlockInfoLocalDataSource

    @Binds
    @Singleton
    abstract fun providesBlockRemoteDataSource(
        blockRemoteDataSourceImpl: BlockRemoteDataSourceImpl
    ) : BlockRemoteDataSource

    @Binds
    @Singleton
    abstract fun providesBlockLocalDataSource(
        blockLocalDataSourceImpl: BlockLocalDataSourceImpl
    ) : BlockLocalDataSource
}