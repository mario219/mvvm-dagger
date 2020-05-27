package com.example.domain.model

import com.example.domain.utils.DEFAULT_ID

data class Block(
    val refBlockPrefix: Long? = null,
    val previous: String? = null,
    val scheduleVersion: Int? = null,
    val confirmed: Int? = null,
    val blockNum: Int? = null,
    val producer: String? = null,
    val transactionMroot: String? = null,
    val id: String = DEFAULT_ID,
    val actionMroot: String? = null,
    val timestamp: String? = null
)
