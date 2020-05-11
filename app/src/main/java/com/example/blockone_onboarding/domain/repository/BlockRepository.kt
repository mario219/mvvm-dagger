package com.example.blockone_onboarding.domain.repository

import com.example.blockone_onboarding.domain.model.Block

interface BlockRepository {

    suspend fun getBlock(blockNumId: String): Block
    suspend fun loadCachedBlocks(): Block
}