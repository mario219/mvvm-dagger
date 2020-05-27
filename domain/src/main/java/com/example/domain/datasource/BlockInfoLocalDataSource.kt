package com.example.domain.datasource

import com.example.domain.model.BlockInfo

interface BlockInfoLocalDataSource {

    suspend fun getBlockInfo(): BlockInfo
    suspend fun saveBlockInfo(blockInfo: BlockInfo)
}