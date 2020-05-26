package com.example.blockone_onboarding.screens.blocklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Config
import androidx.paging.toLiveData
import com.example.blockone_onboarding.domain.usecase.LoadCachedBlocksUseCase
import com.example.blockone_onboarding.domain.usecase.StartFetchingBlocksUseCase
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

class BlockListViewModel @Inject constructor(
    private val startFetchingBlocksUseCase: StartFetchingBlocksUseCase,
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
                startFetchingBlocksUseCase(headBlockNum)
            } while (viewModelScope.isActive)
        }
    }
}