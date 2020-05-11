package com.example.blockone_onboarding.screens.homeblock

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blockone_onboarding.domain.API_ERROR_MESSAGE_TAG
import com.example.blockone_onboarding.domain.DB_ERROR_TAG
import com.example.blockone_onboarding.domain.EMPTY_STRING
import com.example.blockone_onboarding.domain.repository.BlockInfoRepository
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class HomeBlockViewModel @Inject constructor(
    private val infoRepository: BlockInfoRepository
) : ViewModel() {

    private val _blockNumInfo = MutableLiveData<String>()
    val blockNumInfo: LiveData<String>
        get() = _blockNumInfo

    init {
        _blockNumInfo.value = EMPTY_STRING
        fetchBlockInfo()
    }

    fun fetchBlockInfo() {
        viewModelScope.launch {
            try {
                infoRepository.getBlockInfo()
            } catch (e: Exception) {
                Log.e(API_ERROR_MESSAGE_TAG, e.toString())
            }
        }
        updateHeadBlockNum()
    }

    private fun updateHeadBlockNum() {
        viewModelScope.launch {
            try {
                _blockNumInfo.value = infoRepository.getCachedBlockInfo().headBlockNum.toString()
            } catch (e: Exception) {
                Log.e(DB_ERROR_TAG, e.toString())
            }
        }
    }

    fun retryFetchingBlockInfo() {
        updateHeadBlockNum()
    }
}