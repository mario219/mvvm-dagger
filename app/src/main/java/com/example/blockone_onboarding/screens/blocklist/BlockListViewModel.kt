package com.example.blockone_onboarding.screens.blocklist

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Config
import androidx.paging.toLiveData
import com.example.domain.utils.EMPTY_STRING
import com.example.domain.usecase.LoadCachedBlocksUseCase
import com.example.domain.usecase.StartFetchingBlocksUseCase
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

class BlockListViewModel @Inject constructor(
    private val startFetchingBlocksUseCase: StartFetchingBlocksUseCase,
    private val prefs: SharedPreferences,
    loadCachedBlocksUseCase: LoadCachedBlocksUseCase
) : ViewModel() {

    val blockList = loadCachedBlocksUseCase().toLiveData(
        Config(
            pageSize = 20,
            enablePlaceholders = true,
            maxSize = 100
        )
    )

    fun startFetchingData(headBlockNum: String) {
        viewModelScope.launch {
            do {
                val previousBlock = prefs.getString(PREV,
                    EMPTY_STRING
                ) ?: EMPTY_STRING
                startFetchingBlocksUseCase(headBlockNum, previousBlock) { oldBlock ->
                    updatePreviousBlock(oldBlock)
                }
            } while (viewModelScope.isActive)
        }
    }

    private fun updatePreviousBlock(previous: String) {
        prefs.edit().putString(PREV, previous).apply()
    }

    companion object {
        private const val PREV = "PREVIOUS"
    }
}