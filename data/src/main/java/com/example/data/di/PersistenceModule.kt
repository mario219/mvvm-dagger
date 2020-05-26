package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.persistence.BlockOneDataBase
import com.example.data.persistence.dao.BlockDao
import com.example.data.persistence.dao.BlockInfoDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal object PersistenceModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideDataBase(context: Context): BlockOneDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            BlockOneDataBase::class.java,
            "blockone.db"
        ).build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun providesBlockInfoDao(
        database: BlockOneDataBase
    ): BlockInfoDao {
        return database.blockInfoDao()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun providesBlockDao(
        database: BlockOneDataBase
    ): BlockDao {
        return database.blockDao()
    }
}