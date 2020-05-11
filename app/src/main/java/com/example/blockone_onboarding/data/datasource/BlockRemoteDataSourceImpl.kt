package com.example.blockone_onboarding.data.datasource

import com.example.blockone_onboarding.data.mapper.BaseRemoteMapper
import com.example.blockone_onboarding.data.model.remote.BlockRemote
import com.example.blockone_onboarding.data.service.BlockApi
import com.example.blockone_onboarding.domain.datasource.BlockRemoteDataSource
import com.example.blockone_onboarding.domain.model.Block
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BlockRemoteDataSourceImpl @Inject constructor(
    private val blockApi: BlockApi,
    private val mapper: BaseRemoteMapper<BlockRemote, Block>
) : BlockRemoteDataSource {

    override suspend fun getBlock(blockNumId: String): Block {
        val blockRemote = blockApi.getBlock(blockNumId)
        return withContext(Dispatchers.IO) {
            mapper.transform(blockRemote)
        }
    }
}