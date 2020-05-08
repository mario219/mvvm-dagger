package com.example.blockone_onboarding.data.persistence.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.blockone_onboarding.data.model.local.BlockInfoLocal

@Dao
interface BlockInfoDao : BaseDao<BlockInfoLocal> {

    @Query("SELECT * FROM block_info")
    suspend fun getBlockInfo(): BlockInfoLocal

    @Query("DELETE FROM block_info")
    fun clean()
}