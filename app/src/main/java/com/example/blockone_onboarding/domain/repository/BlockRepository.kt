package com.example.blockone_onboarding.domain.repository

import androidx.paging.DataSource
import com.example.blockone_onboarding.domain.model.Block

interface BlockRepository {

    suspend fun startFetchingBlocks(blockNumId: String)
    fun loadCachedBlocks(): DataSource.Factory<Int, Block>
}