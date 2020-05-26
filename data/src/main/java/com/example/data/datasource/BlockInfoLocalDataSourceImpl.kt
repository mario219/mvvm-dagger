package com.example.data.datasource

import com.example.data.mapper.BlockInfoLocalMapper
import com.example.data.persistence.dao.BlockInfoDao
import com.example.domain.datasource.BlockInfoLocalDataSource
import com.example.domain.model.BlockInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class BlockInfoLocalDataSourceImpl @Inject constructor(
    private val dao: BlockInfoDao,
    private val mapper: BlockInfoLocalMapper
) : BlockInfoLocalDataSource {

    override suspend fun getBlockInfo(): BlockInfo {
        val blockInfoLocal = dao.getHeadBlockNum()
        return withContext(Dispatchers.IO) {
            mapper.transform(blockInfoLocal)
        }
    }

    override suspend fun saveBlockInfo(blockInfo: BlockInfo) {
        dao.updateBlockInfo(mapper.transformToEntity(blockInfo))
    }
}