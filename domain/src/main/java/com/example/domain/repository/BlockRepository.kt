package com.example.domain.repository

import androidx.paging.DataSource
import com.example.domain.model.Block

interface BlockRepository {

    suspend fun fetchBlock(blockNumId: String): Block?
    suspend fun getBlockByNum(blockNum: Int): Block
    fun loadCachedBlocks(): DataSource.Factory<Int, Block>
    suspend fun clearFetchedBlocks()
}