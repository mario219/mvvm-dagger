package com.example.blockone_onboarding.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
 * For simplicity it's gonna be saved only the data we need
 */

@Entity(tableName = "block")
data class BlockLocal(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,
    @ColumnInfo(name = "block_num")
    var blockNum: String? = null,
    @ColumnInfo(name = "timestamp")
    var timestamp: String? = null,
    @ColumnInfo(name = "producer")
    var producer: String? = null,
    @ColumnInfo(name = "confirmed")
    var confirmed: String? = null,
    @ColumnInfo(name = "previous")
    var previous: String? = null,
    @ColumnInfo(name = "transaction_mroot")
    var transactionMroot: String? = null,
    @ColumnInfo(name = "action_mroot")
    var actionMroot: String? = null,
    @ColumnInfo(name = "schedule_version")
    var scheduleVersion: String? = null,
    @ColumnInfo(name = "ref_block_prefix")
    var refBlockPrefix: String? = null
)