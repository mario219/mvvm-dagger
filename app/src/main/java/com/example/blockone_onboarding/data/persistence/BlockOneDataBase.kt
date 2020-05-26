package com.example.blockone_onboarding.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.blockone_onboarding.data.model.local.BlockInfoLocal
import com.example.blockone_onboarding.data.model.local.BlockLocal
import com.example.blockone_onboarding.data.persistence.dao.BlockDao
import com.example.blockone_onboarding.data.persistence.dao.BlockInfoDao

@Database(
    entities = [
        BlockInfoLocal::class,
        BlockLocal::class
    ],
    version = 3,
    exportSchema = false
)
abstract class BlockOneDataBase : RoomDatabase() {

    abstract fun blockInfoDao(): BlockInfoDao
    abstract fun blockDao(): BlockDao
}