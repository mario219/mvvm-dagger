package com.example.blockone_onboarding.data.persistence.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import com.example.blockone_onboarding.data.model.local.BlockLocal

@Dao
interface BlockDao : BaseDao<BlockLocal> {

    @Query("SELECT * FROM block ORDER BY block_num DESC")
    fun getBlocks(): DataSource.Factory<Int, BlockLocal>

    @Query("DELETE FROM block")
    suspend fun clean()

    @Query("SELECT * FROM block WHERE block_num = :blockNum LIMIT 1")
    suspend fun getBlockByNum(blockNum: Int): BlockLocal
}