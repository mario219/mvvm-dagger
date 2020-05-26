package com.example.blockone_onboarding.domain.datasource

import com.example.blockone_onboarding.domain.model.Block

interface BlockRemoteDataSource {

    suspend fun fetchBlock(blockNumId: String): Block
}