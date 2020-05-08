package com.example.blockone_onboarding.domain.datasource

import com.example.blockone_onboarding.domain.model.BlockInfo

interface BlockInfoLocalDataSource {

    suspend fun getBlockInfo(): BlockInfo
    suspend fun saveBlockInfo(blockInfo: BlockInfo)
}