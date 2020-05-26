package com.example.blockone_onboarding.domain.usecase

import com.example.blockone_onboarding.domain.model.Block
import com.example.blockone_onboarding.domain.repository.BlockRepository
import javax.inject.Inject

class GetBlockDetailUseCase @Inject constructor(
    private val repository: BlockRepository
) {

    suspend operator fun invoke(blockNum: Int): Block {
        return repository.getBlockByNum(blockNum)
    }
}