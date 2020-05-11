package com.example.blockone_onboarding.domain.datasource

import com.example.blockone_onboarding.domain.model.Block

interface BlockLocalDataSource {

    suspend fun getBlocks(): Block
    suspend fun saveBlock(block: Block)
}