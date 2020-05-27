package com.example.domain.usecase

import com.example.domain.repository.BlockRepository
import javax.inject.Inject

class ClearBlocksUseCase @Inject constructor(
    private val repository: BlockRepository
) {
    suspend operator fun invoke() {
        repository.clearFetchedBlocks()
    }
}