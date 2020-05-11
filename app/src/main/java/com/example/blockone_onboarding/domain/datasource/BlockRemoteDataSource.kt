package com.example.blockone_onboarding.domain.datasource

import com.example.blockone_onboarding.domain.model.Block

interface BlockRemoteDataSource {

    suspend fun getBlock(blockNumId: String): Block
}