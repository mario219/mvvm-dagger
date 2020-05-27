package com.example.data.di

import com.example.data.mapper.BaseMapper
import com.example.data.mapper.BaseRemoteMapper
import com.example.data.mapper.BlockInfoLocalMapper
import com.example.data.mapper.BlockInfoRemoteMapper
import com.example.data.mapper.BlockLocalMapper
import com.example.data.mapper.BlockRemoteMapper
import com.example.data.model.local.BlockInfoLocal
import com.example.data.model.local.BlockLocal
import com.example.blockone_onboarding.data.model.remote.BlockInfoRemote
import com.example.blockone_onboarding.data.model.remote.BlockRemote
import com.example.domain.model.Block
import com.example.domain.model.BlockInfo
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class MappersModule {

    @Binds
    @Singleton
    abstract fun providesBlockInfoRemoteMapper(
        blockInfoRemoteMapper: BlockInfoRemoteMapper
    ): BaseRemoteMapper<BlockInfoRemote, BlockInfo>

    @Binds
    @Singleton
    abstract fun providesBlockInfoLocalMapper(
        blockInfoLocalMapper: BlockInfoLocalMapper
    ): BaseMapper<BlockInfoLocal, BlockInfo>

    @Binds
    @Singleton
    abstract fun providesBlockRemoteMapper(
        blockRemoteMapper: BlockRemoteMapper
    ): BaseRemoteMapper<BlockRemote, Block>

    @Binds
    @Singleton
    abstract fun providesBlockLocalMapper(
        blockLocalMapper: BlockLocalMapper
    ): BaseMapper<BlockLocal, Block>
}
