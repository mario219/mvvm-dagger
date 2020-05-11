package com.example.blockone_onboarding.data.repository

import com.example.blockone_onboarding.domain.datasource.BlockLocalDataSource
import com.example.blockone_onboarding.domain.datasource.BlockRemoteDataSource
import com.example.blockone_onboarding.domain.model.Block
import com.example.blockone_onboarding.domain.repository.BlockRepository
import javax.inject.Inject

class BlockRepositoryImpl @Inject constructor(
    private val remoteDataSource: BlockRemoteDataSource,
    private val localDataSource: BlockLocalDataSource
) : BlockRepository {

    override suspend fun getBlock(blockNumId: String): Block {
        val block = remoteDataSource.getBlock(blockNumId)
        localDataSource.saveBlock(block)
        return block
    }

    override suspend fun loadCachedBlocks(): Block {
        return localDataSource.getBlocks()
    }
}