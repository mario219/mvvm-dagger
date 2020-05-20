package com.example.blockone_onboarding.domain.usecase

import androidx.paging.DataSource
import com.example.blockone_onboarding.domain.model.Block
import com.example.blockone_onboarding.domain.repository.BlockRepository
import javax.inject.Inject

class LoadCachedBlocksUseCase @Inject constructor(
    private val repository: BlockRepository
) {

    operator fun invoke(): DataSource.Factory<Int, Block> {
        return repository.loadCachedBlocks()
    }
}