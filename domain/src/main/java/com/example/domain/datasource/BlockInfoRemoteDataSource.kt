package com.example.domain.datasource

import com.example.domain.model.BlockInfo

interface BlockInfoRemoteDataSource {

    suspend fun getBlockInfo(): BlockInfo
}