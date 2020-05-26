package com.example.blockone_onboarding.domain.usecase

import com.example.blockone_onboarding.domain.repository.BlockInfoRepository
import javax.inject.Inject

class FetchBlockInfoUseCase @Inject constructor(
    private val repository: BlockInfoRepository
) {

    suspend operator fun invoke() {
        repository.fetchBlockInfo()
    }
}