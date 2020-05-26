package com.example.domain.usecase

import com.example.domain.repository.BlockInfoRepository
import javax.inject.Inject

class FetchBlockInfoUseCase @Inject constructor(
    private val repository: BlockInfoRepository
) {

    suspend operator fun invoke() {
        repository.fetchBlockInfo()
    }
}