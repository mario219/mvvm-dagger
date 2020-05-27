package com.example.domain.usecase

import com.example.domain.repository.BlockRepository
import javax.inject.Inject

class StartFetchingBlocksUseCase @Inject constructor(
    private val repository: BlockRepository
) {
    suspend operator fun invoke(
        blockNumId: String,
        previousBlock: String,
        callback: (String) -> Unit
    ) {
        val oldBlock = if (previousBlock.isNotEmpty()) {
            repository.fetchBlock(previousBlock)
        } else {
            repository.fetchBlock(blockNumId)
        }
        oldBlock?.run {
            callback(previous.toString())
        }
    }
}