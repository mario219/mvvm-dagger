package com.example.blockone_onboarding.screens.homeblock

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blockone_onboarding.domain.API_ERROR_MESSAGE_TAG
import com.example.blockone_onboarding.domain.DB_ERROR_TAG
import com.example.blockone_onboarding.domain.EMPTY_STRING
import com.example.blockone_onboarding.domain.repository.BlockRepository
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class HomeBlockViewModel @Inject constructor(
    private val repository: BlockRepository
) : ViewModel() {

    private val _blockNumInfo = MutableLiveData<String>()
    val blockNumInfo: LiveData<String>
        get() = _blockNumInfo

    init {
        _blockNumInfo.value = EMPTY_STRING
        fetchBlockInfo()
        getHeadBlockNum()
    }

    fun retryFetchingBlockInfo() {
        getHeadBlockNum()
    }

    private fun fetchBlockInfo() {
        viewModelScope.launch {
            try {
                repository.getBlockInfo()
            } catch (e: Exception) {
                Log.e(API_ERROR_MESSAGE_TAG, e.toString())
            }
        }
    }

    private fun getHeadBlockNum() {
        viewModelScope.launch {
            try {
                _blockNumInfo.value = repository.getSavedBlockInfo().headBlockNum.toString()
            } catch (e: Exception) {
                Log.e(DB_ERROR_TAG, e.toString())
            }
        }
    }
}