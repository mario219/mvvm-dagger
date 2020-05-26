package com.example.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.model.local.BlockInfoLocal
import com.example.data.model.local.BlockLocal
import com.example.data.persistence.dao.BlockDao
import com.example.data.persistence.dao.BlockInfoDao

@Database(
    entities = [
        BlockInfoLocal::class,
        BlockLocal::class
    ],
    version = 3,
    exportSchema = false
)
internal abstract class BlockOneDataBase : RoomDatabase() {

    abstract fun blockInfoDao(): BlockInfoDao
    abstract fun blockDao(): BlockDao
}