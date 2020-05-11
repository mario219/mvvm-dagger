package com.example.blockone_onboarding.data.repository

import com.example.blockone_onboarding.domain.datasource.BlockInfoLocalDataSource
import com.example.blockone_onboarding.domain.datasource.BlockInfoRemoteDataSource
import com.example.blockone_onboarding.domain.model.BlockInfo
import com.example.blockone_onboarding.domain.repository.BlockInfoRepository
import javax.inject.Inject

class BlockInfoRepositoryImpl @Inject constructor(
    private val remoteDataSource: BlockInfoRemoteDataSource,
    private val localDataSource: BlockInfoLocalDataSource
) : BlockInfoRepository {

    override suspend fun getBlockInfo(): BlockInfo {
        val blockInfo = remoteDataSource.getBlockInfo()
        localDataSource.saveBlockInfo(blockInfo)
        return blockInfo
    }

    override suspend fun getCachedBlockInfo(): BlockInfo {
        return localDataSource.getBlockInfo()
    }
}