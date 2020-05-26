package com.example.domain.repository

import com.example.domain.model.BlockInfo

interface BlockInfoRepository {

    suspend fun fetchBlockInfo()
    suspend fun getCachedBlockInfo(): BlockInfo?
}