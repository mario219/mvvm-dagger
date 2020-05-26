package com.example.blockone_onboarding.domain.repository

import com.example.blockone_onboarding.domain.model.BlockInfo

interface BlockInfoRepository {

    suspend fun fetchBlockInfo()
    suspend fun getCachedBlockInfo(): BlockInfo?
}