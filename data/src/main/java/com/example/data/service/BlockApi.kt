package com.example.data.service

import com.example.blockone_onboarding.data.model.remote.BlockInfoRemote
import com.example.data.model.remote.BlockRemote
import com.example.data.utils.API_PATH_BLOCK
import com.example.data.utils.API_PATH_BLOCK_INFO
import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

internal interface BlockApi {

    @GET(API_PATH_BLOCK_INFO)
    suspend fun getBlockInfo(): BlockInfoRemote

    @POST(API_PATH_BLOCK)
    suspend fun getBlock(@Body blockNumId: JsonObject): BlockRemote
}