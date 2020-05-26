package com.example.domain.datasource

import androidx.paging.DataSource
import com.example.domain.model.Block

interface BlockLocalDataSource {

    fun getBlocks(): DataSource.Factory<Int, Block>
    suspend fun saveBlock(block: Block)
    suspend fun deleteAllBlocks()
    suspend fun getBlockByNum(blockNum: Int): Block
}