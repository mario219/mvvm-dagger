package com.example.blockone_onboarding.domain.datasource

import com.example.blockone_onboarding.domain.model.BlockInfo

interface BlockInfoRemoteDataSource {

    suspend fun getBlockInfo(): BlockInfo
}