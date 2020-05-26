package com.example.blockone_onboarding.domain.repository

import androidx.paging.DataSource
import com.example.blockone_onboarding.domain.model.Block

interface BlockRepository {

    suspend fun fetchBlock(blockNumId: String): Block?
    suspend fun getBlockByNum(blockNum: Int): Block
    fun loadCachedBlocks(): DataSource.Factory<Int, Block>
    suspend fun clearFetchedBlocks()
}