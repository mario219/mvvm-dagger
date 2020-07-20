package com.example.data.datasource

import androidx.paging.DataSource
import com.example.data.mapper.BaseMapper
import com.example.data.mapper.BlockLocalMapper
import com.example.data.model.local.BlockLocal
import com.example.data.persistence.dao.BlockDao
import com.example.domain.datasource.BlockLocalDataSource
import com.example.domain.model.Block
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class BlockLocalDataSourceImpl @Inject constructor(
    private val dao: BlockDao,
    private val mapper: BaseMapper<BlockLocal, Block>
) : BlockLocalDataSource {

    override fun getBlocks(): DataSource.Factory<Int, Block> {
        return dao.getBlocks().map {
            mapper.transform(it)
        }
    }

    override suspend fun saveBlock(block: Block) {
        dao.insert(mapper.transformToEntity(block))
    }

    override suspend fun getBlockByNum(blockNum: Int): Block {
        val blockLocal = dao.getBlockByNum(blockNum)
        return withContext(Dispatchers.IO) {
            mapper.transform(blockLocal)
        }
    }

    override suspend fun deleteAllBlocks() {
        dao.clean()
    }
}