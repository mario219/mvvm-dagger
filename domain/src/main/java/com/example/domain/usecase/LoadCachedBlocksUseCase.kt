package com.example.domain.usecase

import androidx.paging.DataSource
import com.example.domain.model.Block
import com.example.domain.repository.BlockRepository
import javax.inject.Inject

class LoadCachedBlocksUseCase @Inject constructor(
    private val repository: BlockRepository
) {

    operator fun invoke(): DataSource.Factory<Int, Block> {
        return repository.loadCachedBlocks()
    }
}