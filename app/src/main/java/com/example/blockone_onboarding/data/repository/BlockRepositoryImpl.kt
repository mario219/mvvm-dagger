package com.example.blockone_onboarding.data.repository

import com.example.blockone_onboarding.domain.EMPTY_STRING
import com.example.blockone_onboarding.domain.datasource.BlockInfoLocalDataSource
import com.example.blockone_onboarding.domain.datasource.BlockInfoRemoteDataSource
import com.example.blockone_onboarding.domain.model.Block
import com.example.blockone_onboarding.domain.model.BlockInfo
import com.example.blockone_onboarding.domain.repository.BlockRepository
import javax.inject.Inject

class BlockRepositoryImpl @Inject constructor(
    private val dataSource: BlockInfoRemoteDataSource,
    private val localDataSource: BlockInfoLocalDataSource
) : BlockRepository {

    override suspend fun getBlockInfo(): BlockInfo {
        val blockInfo = dataSource.getBlockInfo()
        localDataSource.saveBlockInfo(blockInfo)
        return blockInfo
    }

    override suspend fun getBlock(): Block {
        return Block(EMPTY_STRING)
    }

    override suspend fun getSavedBlockInfo(): BlockInfo {
        return localDataSource.getBlockInfo()
    }
}