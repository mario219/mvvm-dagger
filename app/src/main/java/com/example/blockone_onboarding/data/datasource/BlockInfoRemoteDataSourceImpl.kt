package com.example.blockone_onboarding.data.datasource

import com.example.blockone_onboarding.data.mapper.BaseRemoteMapper
import com.example.blockone_onboarding.data.model.remote.BlockInfoRemote
import com.example.blockone_onboarding.data.service.BlockApi
import com.example.blockone_onboarding.domain.datasource.BlockInfoRemoteDataSource
import com.example.blockone_onboarding.domain.model.BlockInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BlockInfoRemoteDataSourceImpl @Inject constructor(
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