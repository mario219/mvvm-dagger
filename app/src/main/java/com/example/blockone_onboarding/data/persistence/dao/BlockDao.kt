package com.example.blockone_onboarding.data.persistence.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import com.example.blockone_onboarding.data.model.local.BlockLocal

@Dao
interface BlockDao : BaseDao<BlockLocal> {

    @Query("SELECT * FROM block")
    suspend fun getBlocks(): BlockLocal

    @Query("DELETE FROM block")
    suspend fun clean()
}