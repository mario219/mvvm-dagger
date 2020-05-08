package com.example.blockone_onboarding.domain.repository

import com.example.blockone_onboarding.domain.model.Block
import com.example.blockone_onboarding.domain.model.BlockInfo

interface BlockRepository {

    suspend fun getBlockInfo(): BlockInfo
    suspend fun getBlock(): Block
    suspend fun getSavedBlockInfo(): BlockInfo
}