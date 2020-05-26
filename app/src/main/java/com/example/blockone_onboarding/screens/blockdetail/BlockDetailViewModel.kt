package com.example.blockone_onboarding.screens.blockdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blockone_onboarding.domain.model.Block
import com.example.blockone_onboarding.domain.usecase.GetBlockDetailUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class BlockDetailViewModel @Inject constructor(
    private val getBlockDetailUseCase: GetBlockDetailUseCase
) : ViewModel() {

    private val _blockDetail = MutableLiveData<Block>()
    val blockDetail: LiveData<Block>
        get() = _blockDetail

    fun getBlockDetail(blockNum: Int) {
        viewModelScope.launch {
            _blockDetail.value = getBlockDetailUseCase(blockNum)
        }
    }
}