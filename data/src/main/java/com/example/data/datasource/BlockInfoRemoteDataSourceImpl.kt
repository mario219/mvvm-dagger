package com.example.data.datasource

import com.example.data.mapper.BaseRemoteMapper
import com.example.blockone_onboarding.data.model.remote.BlockInfoRemote
import com.example.data.service.BlockApi
import com.example.domain.datasource.BlockInfoRemoteDataSource
import com.example.domain.model.BlockInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class BlockInfoRemoteDataSourceImpl @Inject constructor(
    private val blockApi: BlockApi,
    private val mapper: BaseRemoteMapper<BlockInfoRemote, BlockInfo>
) : BlockInfoRemoteDataSource {

    override suspend fun getBlockInfo(): BlockInfo {
        val infoRemote = blockApi.getBlockInfo()
        return withContext(Dispatchers.IO) {
            mapper.transform(infoRemote)
        }
    }
}