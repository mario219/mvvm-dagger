package com.example.blockone_onboarding.data.persistence.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.blockone_onboarding.data.model.local.BlockInfoLocal

@Dao
interface BlockInfoDao : BaseDao<BlockInfoLocal> {

    @Query("SELECT head_block_num FROM block_info")
    suspend fun getHeadBlockNum(): BlockInfoLocal

    @Query("DELETE FROM block_info")
    suspend fun clean()

    @Transaction
    suspend fun updateBlockInfo(blockInfoLocal: BlockInfoLocal) {
        clean()
        insert(blockInfoLocal)
    }
}