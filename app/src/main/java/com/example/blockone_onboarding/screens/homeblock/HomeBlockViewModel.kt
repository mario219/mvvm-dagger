package com.example.blockone_onboarding.screens.homeblock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blockone_onboarding.domain.EMPTY_STRING
import com.example.blockone_onboarding.domain.usecase.ClearBlocksUseCase
import com.example.blockone_onboarding.domain.usecase.FetchBlockInfoUseCase
import com.example.blockone_onboarding.domain.usecase.GetCachedBlockNumUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeBlockViewModel @Inject constructor(
    private val fetchBlockInfoUseCase: FetchBlockInfoUseCase,
    private val getCachedBlockNumUseCase: GetCachedBlockNumUseCase,
    private val clearBlocksUseCase: ClearBlocksUseCase
) : ViewModel() {

    private val _blockNumInfo = MutableLiveData<String>()
    val blockNumInfo: LiveData<String>
        get() = _blockNumInfo

    init {
        _blockNumInfo.value = EMPTY_STRING
        fetchBlockInfo()
    }

    fun clearCachedData() {
        viewModelScope.launch {
            clearBlocksUseCase()
        }
    }

    fun fetchBlockInfo() {
        viewModelScope.launch {
            fetchBlockInfoUseCase()
        }
        updateHeadBlockNum()
    }

    fun retryFetchingBlockInfo() {
        updateHeadBlockNum()
    }

    private fun updateHeadBlockNum() {
        viewModelScope.launch {
            _blockNumInfo.value = getCachedBlockNumUseCase()
        }
    }
}