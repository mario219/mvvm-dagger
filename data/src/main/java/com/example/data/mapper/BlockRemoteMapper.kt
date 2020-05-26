package com.example.data.mapper

import com.example.blockone_onboarding.data.model.remote.BlockRemote
import com.example.domain.utils.DEFAULT_ID
import com.example.domain.model.Block
import javax.inject.Inject

internal class BlockRemoteMapper @Inject constructor() : BaseRemoteMapper<BlockRemote, Block> {

    override fun transform(input: BlockRemote): Block {
        return Block(
            refBlockPrefix = input.refBlockPrefix,
            previous = input.previous,
            scheduleVersion = input.scheduleVersion,
            confirmed = input.confirmed,
            blockNum = input.blockNum,
            producer = input.producer,
            transactionMroot = input.transactionMroot,
            id = input.id ?: DEFAULT_ID,
            actionMroot = input.actionMroot,
            timestamp = input.timestamp
        )
    }
}