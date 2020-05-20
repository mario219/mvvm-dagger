package com.example.blockone_onboarding.data.repository

import android.util.Log
import androidx.paging.DataSource
import com.example.blockone_onboarding.data.utils.API_ERROR_MESSAGE_TAG
import com.example.blockone_onboarding.domain.datasource.BlockLocalDataSource
import com.example.blockone_onboarding.domain.datasource.BlockRemoteDataSource
import com.example.blockone_onboarding.domain.model.Block
import com.example.blockone_onboarding.domain.repository.BlockRepository
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

    override fun loadCachedBlocks(): DataSource.Factory<Int, Block> {
        return localDataSource.getBlocks()
    }

    override suspend fun clearFetchedBlocks() {
        localDataSource.deleteAllBlocks()
    }
}