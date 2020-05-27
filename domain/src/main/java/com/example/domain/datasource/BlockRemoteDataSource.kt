package com.example.domain.datasource

import com.example.domain.model.Block

interface BlockRemoteDataSource {

    suspend fun fetchBlock(blockNumId: String): Block
}