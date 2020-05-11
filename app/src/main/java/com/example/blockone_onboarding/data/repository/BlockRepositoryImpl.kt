package com.example.blockone_onboarding.data.repository

import android.content.SharedPreferences
import androidx.paging.DataSource
import com.example.blockone_onboarding.domain.EMPTY_STRING
import com.example.blockone_onboarding.domain.PAGE_LIST_SIZE
import com.example.blockone_onboarding.domain.datasource.BlockLocalDataSource
import com.example.blockone_onboarding.domain.datasource.BlockRemoteDataSource
import com.example.blockone_onboarding.domain.model.Block
import com.example.blockone_onboarding.domain.repository.BlockRepository
import javax.inject.Inject

class BlockRepositoryImpl @Inject constructor(
    private val remoteDataSource: BlockRemoteDataSource,
    private val localDataSource: BlockLocalDataSource,
    private val preferences: SharedPreferences
) : BlockRepository {

    override suspend fun startFetchingBlocks(blockNumId: String) {
        val previousBlock = preferences.getString(PREV, EMPTY_STRING) ?: EMPTY_STRING
        if (previousBlock.isNotEmpty()) {
            startFetching(previousBlock)
        } else {
            startFetching(blockNumId)
        }
    }

    // TODO: Create an use case for this
    private suspend fun startFetching(blockNumId: String) {
        val block = remoteDataSource.fetchBlock(blockNumId)
        localDataSource.saveBlock(block)
        var oldBlock = block
        for (i in 0..PAGE_LIST_SIZE) {
            val previous = remoteDataSource.fetchBlock(oldBlock.previous.toString())
            localDataSource.saveBlock(previous)
            oldBlock = previous
            preferences.edit().putString(PREV, oldBlock.previous).apply()
        }
    }

    override fun loadCachedBlocks(): DataSource.Factory<Int, Block> {
        return localDataSource.getBlocks()
    }

    companion object {
        private const val PREV = "PREVIOUS"
    }
}