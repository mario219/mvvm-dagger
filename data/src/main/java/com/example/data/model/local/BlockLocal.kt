package com.example.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
 * For simplicity it's gonna be saved only the data we need
 */

@Entity(tableName = "block")
internal data class BlockLocal(
    @PrimaryKey
    @ColumnInfo(name = "block_num")
    var blockNum: Int? = null,
    @ColumnInfo(name = "id")
    var id: String,
    @ColumnInfo(name = "timestamp")
    var timestamp: String? = null,
    @ColumnInfo(name = "producer")
    var producer: String? = null,
    @ColumnInfo(name = "confirmed")
    var confirmed: Int? = null,
    @ColumnInfo(name = "previous")
    var previous: String? = null,
    @ColumnInfo(name = "transaction_mroot")
    var transactionMroot: String? = null,
    @ColumnInfo(name = "action_mroot")
    var actionMroot: String? = null,
    @ColumnInfo(name = "schedule_version")
    var scheduleVersion: Int? = null,
    @ColumnInfo(name = "ref_block_prefix")
    var refBlockPrefix: Long? = null
)