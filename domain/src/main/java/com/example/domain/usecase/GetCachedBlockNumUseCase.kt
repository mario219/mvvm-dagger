package com.example.domain.usecase

import com.example.domain.utils.EMPTY_STRING
import com.example.domain.repository.BlockInfoRepository
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