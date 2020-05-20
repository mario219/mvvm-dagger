package com.example.blockone_onboarding.domain.usecase

import com.example.blockone_onboarding.domain.repository.BlockRepository
import javax.inject.Inject

class ClearBlocksUseCase @Inject constructor(
    private val repository: BlockRepository
) {
    suspend operator fun invoke() {
        repository.clearFetchedBlocks()
    }
}