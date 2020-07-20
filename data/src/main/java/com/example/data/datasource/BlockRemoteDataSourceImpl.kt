package com.example.data.datasource

import com.example.data.mapper.BaseRemoteMapper
import com.example.data.model.remote.BlockRemote
import com.example.data.service.BlockApi
import com.example.data.utils.BLOCK_ID
import com.example.domain.datasource.BlockRemoteDataSource
import com.example.domain.model.Block
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class BlockRemoteDataSourceImpl @Inject constructor(
    private val blockApi: BlockApi,
    private val mapper: BaseRemoteMapper<BlockRemote, Block>
) : BlockRemoteDataSource {

    override suspend fun fetchBlock(blockNumId: String): Block {
        val blockRemote = blockApi.getBlock(createBodyForRequest(blockNumId))
        return withContext(Dispatchers.IO) {
            mapper.transform(blockRemote)
        }
    }

    private fun createBodyForRequest(blockNumId: String): JsonObject {
        val body = JsonObject()
        body.addProperty(BLOCK_ID, blockNumId)
        return body
    }
}