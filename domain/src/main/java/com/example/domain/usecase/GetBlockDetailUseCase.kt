package com.example.domain.usecase

import com.example.domain.model.Block
import com.example.domain.repository.BlockRepository
import javax.inject.Inject

class GetBlockDetailUseCase @Inject constructor(
    private val repository: BlockRepository
) {

    suspend operator fun invoke(blockNum: Int): Block {
        return repository.getBlockByNum(blockNum)
    }
}