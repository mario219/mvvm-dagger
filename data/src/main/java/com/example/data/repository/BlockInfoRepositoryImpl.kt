package com.example.data.repository

import android.util.Log
import com.example.data.utils.API_ERROR_MESSAGE_TAG
import com.example.data.utils.DB_ERROR_TAG
import com.example.domain.datasource.BlockInfoLocalDataSource
import com.example.domain.datasource.BlockInfoRemoteDataSource
import com.example.domain.model.BlockInfo
import com.example.domain.repository.BlockInfoRepository
import java.lang.Exception
import javax.inject.Inject

class BlockInfoRepositoryImpl @Inject constructor(
    private val remoteDataSource: BlockInfoRemoteDataSource,
    private val localDataSource: BlockInfoLocalDataSource
) : BlockInfoRepository {

    override suspend fun fetchBlockInfo() {
        try {
            val blockInfo = remoteDataSource.getBlockInfo()
            localDataSource.saveBlockInfo(blockInfo)
        } catch (e: Exception) {
            Log.e(API_ERROR_MESSAGE_TAG, e.toString())
        }
    }

    override suspend fun getCachedBlockInfo(): BlockInfo? {
        var blockInfo: BlockInfo? = null
        try {
            blockInfo = localDataSource.getBlockInfo()
        } catch (e: Exception) {
            Log.e(DB_ERROR_TAG, e.toString())
        }
        return blockInfo
    }
}