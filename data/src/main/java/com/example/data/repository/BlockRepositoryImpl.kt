package com.example.data.repository

import android.util.Log
import androidx.paging.DataSource
import com.example.data.utils.API_ERROR_MESSAGE_TAG
import com.example.domain.datasource.BlockLocalDataSource
import com.example.domain.datasource.BlockRemoteDataSource
import com.example.domain.model.Block
import com.example.domain.repository.BlockRepository
import java.lang.Exception
import javax.inject.Inject

class BlockRepositoryImpl @Inject constructor(
    private val remoteDataSource: BlockRemoteDataSource,
    private val localDataSource: BlockLocalDataSource
) : BlockRepository {

    override suspend fun fetchBlock(blockNumId: String): Block? {
        var block: Block? = null
        try {
            block = remoteDataSource.fetchBlock(blockNumId)
            localDataSource.saveBlock(block)
        } catch (e: Exception) {
            Log.e(API_ERROR_MESSAGE_TAG, e.toString())
        }
        return block
    }

    override suspend fun getBlockByNum(blockNum: Int): Block {
        return localDataSource.getBlockByNum(blockNum)
    }

    override fun loadCachedBlocks(): DataSource.Factory<Int, Block> {
        return localDataSource.getBlocks()
    }

    override suspend fun clearFetchedBlocks() {
        localDataSource.deleteAllBlocks()
    }
}