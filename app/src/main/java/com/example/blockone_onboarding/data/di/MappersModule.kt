package com.example.blockone_onboarding.data.di

import com.example.blockone_onboarding.data.mapper.BaseMapper
import com.example.blockone_onboarding.data.mapper.BaseRemoteMapper
import com.example.blockone_onboarding.data.mapper.BlockInfoLocalMapper
import com.example.blockone_onboarding.data.mapper.BlockInfoRemoteMapper
import com.example.blockone_onboarding.data.mapper.BlockLocalMapper
import com.example.blockone_onboarding.data.mapper.BlockRemoteMapper
import com.example.blockone_onboarding.data.model.local.BlockInfoLocal
import com.example.blockone_onboarding.data.model.local.BlockLocal
import com.example.blockone_onboarding.data.model.remote.BlockInfoRemote
import com.example.blockone_onboarding.data.model.remote.BlockRemote
import com.example.blockone_onboarding.domain.model.Block
import com.example.blockone_onboarding.domain.model.BlockInfo
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
