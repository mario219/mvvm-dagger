package com.example.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.utils.EMPTY_STRING

@Entity(tableName = "block_info")
internal data class BlockInfoLocal(
    @PrimaryKey
    @ColumnInfo(name = "head_block_num")
    val headBlockNum: Int? = null,
    @ColumnInfo(name = "fork_db_head_block_num")
    val forkDbHeadBlockNum: Int? = null,
    @ColumnInfo(name = "chain_id")
    val chainId: String? = EMPTY_STRING,
    @ColumnInfo(name = "head_block_time")
    val headBlockTime: String? = EMPTY_STRING,
    @ColumnInfo(name = "virtual_block_net_limit")
    val virtualBlockNetLimit: Int? = null,
    @ColumnInfo(name = "virtual_block_cpu_limit")
    val virtualBlockCpuLimit: Int? = null,
    @ColumnInfo(name = "last_irrv_block_num")
    val lastIrreversibleBlockNum: Int? = null,
    @ColumnInfo(name = "server_version")
    val serverVersion: String? = EMPTY_STRING,
    @ColumnInfo(name = "block_cpu_limit")
    val blockCpuLimit: Int? = null,
    @ColumnInfo(name = "head_block_producer")
    val headBlockProducer: String? = EMPTY_STRING,
    @ColumnInfo(name = "fork_db_head_block_id")
    val forkDbHeadBlockId: String? = EMPTY_STRING,
    @ColumnInfo(name = "last_irrv_block_id")
    val lastIrreversibleBlockId: String? = EMPTY_STRING,
    @ColumnInfo(name = "block_net_limit")
    val blockNetLimit: Int? = null,
    @ColumnInfo(name = "head_block_id")
    val headBlockId: String? = EMPTY_STRING,
    @ColumnInfo(name = "server_full_version_string")
    val serverFullVersionString: String? = EMPTY_STRING,
    @ColumnInfo(name = "server_version_string")
    val serverVersionString: String? = EMPTY_STRING
)