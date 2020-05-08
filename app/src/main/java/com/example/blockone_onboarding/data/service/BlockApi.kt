package com.example.blockone_onboarding.data.service

import com.example.blockone_onboarding.data.model.remote.BlockInfoRemote
import com.example.blockone_onboarding.data.utils.API_PATH_BLOCK
import com.example.blockone_onboarding.data.utils.API_PATH_BLOCK_INFO
import com.example.blockone_onboarding.data.utils.BLOCK_ID
import retrofit2.http.GET
import retrofit2.http.Query

interface BlockApi {

    @GET(API_PATH_BLOCK_INFO)
    suspend fun getBlockInfo(): BlockInfoRemote

    @GET(API_PATH_BLOCK)
    suspend fun getBlock(@Query(BLOCK_ID) blockId: String)
}