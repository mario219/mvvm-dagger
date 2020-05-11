package com.example.blockone_onboarding.data.datasource

import com.example.blockone_onboarding.data.mapper.BlockInfoLocalMapper
import com.example.blockone_onboarding.data.persistence.dao.BlockInfoDao
import com.example.blockone_onboarding.domain.datasource.BlockInfoLocalDataSource
import com.example.blockone_onboarding.domain.model.BlockInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BlockInfoLocalDataSourceImpl @Inject constructor(
    private val dao: BlockInfoDao,
    private val mapper: BlockInfoLocalMapper
) : BlockInfoLocalDataSource {

    override suspend fun getBlockInfo(): BlockInfo {
        val blockInfoLocal = dao.getBlockInfo()
        return withContext(Dispatchers.IO) {
            mapper.transform(blockInfoLocal)
        }
    }

    override suspend fun saveBlockInfo(blockInfo: BlockInfo) {
        dao.insert(
            withContext(Dispatchers.IO) {
                mapper.transformToEntity(blockInfo)
            }
        )
    }
}