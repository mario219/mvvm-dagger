package com.example.blockone_onboarding.domain.datasource

import androidx.paging.DataSource
import com.example.blockone_onboarding.domain.model.Block

interface BlockLocalDataSource {

    fun getBlocks(): DataSource.Factory<Int, Block>
    suspend fun saveBlock(block: Block)
}