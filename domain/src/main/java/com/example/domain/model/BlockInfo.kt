package com.example.domain.model

import com.example.domain.utils.EMPTY_STRING

data class BlockInfo(
    val headBlockNum: Int? = null,
    val forkDbHeadBlockNum: Int? = null,
    val chainId: String? = EMPTY_STRING,
    val headBlockTime: String? = EMPTY_STRING,
    val virtualBlockNetLimit: Int? = null,
    val virtualBlockCpuLimit: Int? = null,
    val lastIrreversibleBlockNum: Int? = null,
    val serverVersion: String? = EMPTY_STRING,
    val blockCpuLimit: Int? = null,
    val headBlockProducer: String? = EMPTY_STRING,
    val forkDbHeadBlockId: String? = EMPTY_STRING,
    val lastIrreversibleBlockId: String? = EMPTY_STRING,
    val blockNetLimit: Int? = null,
    val headBlockId: String? = EMPTY_STRING,
    val serverFullVersionString: String? = EMPTY_STRING,
    val serverVersionString: String? = EMPTY_STRING
)