package com.example.blockone_onboarding.domain.usecase

import android.content.SharedPreferences
import com.example.blockone_onboarding.domain.EMPTY_STRING
import com.example.blockone_onboarding.domain.model.Block
import com.example.blockone_onboarding.domain.repository.BlockRepository
import javax.inject.Inject

class StartFetchingBlocksUseCase @Inject constructor(
    private val repository: BlockRepository,
    private val prefs: SharedPreferences
) {
    suspend operator fun invoke(blockNumId: String) {
        val previousBlock = prefs.getString(PREV, EMPTY_STRING) ?: EMPTY_STRING
        val oldBlock: Block?
        oldBlock = if (previousBlock.isNotEmpty()) {
            repository.fetchBlock(previousBlock)
        } else {
            repository.fetchBlock(blockNumId)
        }
        oldBlock?.run {
            prefs.edit().putString(PREV, previous.toString()).apply()
        }
    }

    companion object {
        private const val PREV = "PREVIOUS"
    }
}