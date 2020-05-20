package com.example.blockone_onboarding.domain.usecase

import com.example.blockone_onboarding.domain.EMPTY_STRING
import com.example.blockone_onboarding.domain.repository.BlockInfoRepository
import javax.inject.Inject

class GetCachedBlockNumUseCase @Inject constructor(
    private val repository: BlockInfoRepository
) {

    suspend operator fun invoke(): String {
        repository.getCachedBlockInfo()?.run {
            return headBlockNum.toString()
        }
        return EMPTY_STRING
    }
}