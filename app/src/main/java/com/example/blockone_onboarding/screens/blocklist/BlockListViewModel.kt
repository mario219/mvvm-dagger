package com.example.blockone_onboarding.screens.blocklist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.blockone_onboarding.domain.API_ERROR_MESSAGE_TAG
import com.example.blockone_onboarding.domain.model.Block
import com.example.blockone_onboarding.domain.repository.BlockRepository
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class BlockListViewModel @Inject constructor(
    private val repository: BlockRepository
) : ViewModel() {

    private val pagedListConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setInitialLoadSizeHint(40)
        .setPageSize(20)
        .build()

    val blockList: LiveData<PagedList<Block>> =
        LivePagedListBuilder(
            repository.loadCachedBlocks(),
            pagedListConfig)
        .build()

    fun startFetchingData(headBlockNum: String) {
        viewModelScope.launch {
            try {
                repository.startFetchingBlocks(headBlockNum)
            } catch (e: Exception) {
                Log.e(API_ERROR_MESSAGE_TAG, e.toString())
            }
        }
    }
}