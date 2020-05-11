package com.example.blockone_onboarding.data.datasource

import com.example.blockone_onboarding.data.mapper.BlockLocalMapper
import com.example.blockone_onboarding.data.persistence.dao.BlockDao
import com.example.blockone_onboarding.domain.datasource.BlockLocalDataSource
import com.example.blockone_onboarding.domain.model.Block
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BlockLocalDataSourceImpl @Inject constructor(
    private val dao: BlockDao,
    private val mapper: BlockLocalMapper
) : BlockLocalDataSource {

    override suspend fun getBlocks(): Block {
        val blockLocal = dao.getBlocks()
        return withContext(Dispatchers.IO) {
            mapper.transform(blockLocal)
        }
    }

    override suspend fun saveBlock(block: Block) {
        dao.insert(
            withContext(Dispatchers.IO) {
                mapper.transformToEntity(block)
            }
        )
    }
}