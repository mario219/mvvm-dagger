package com.example.data.mapper

import com.example.data.model.local.BlockLocal
import com.example.domain.model.Block
import javax.inject.Inject

internal class BlockLocalMapper @Inject constructor() : BaseMapper<BlockLocal, Block> {

    override fun transform(input: BlockLocal): Block {
        return Block(
            refBlockPrefix = input.refBlockPrefix,
            previous = input.previous,
            scheduleVersion = input.scheduleVersion,
            confirmed = input.confirmed,
            blockNum = input.blockNum,
            producer = input.producer,
            transactionMroot = input.transactionMroot,
            id = input.id,
            actionMroot = input.actionMroot,
            timestamp = input.timestamp
        )
    }

    override fun transformToEntity(input: Block): BlockLocal {
        return BlockLocal(
            refBlockPrefix = input.refBlockPrefix,
            previous = input.previous,
            scheduleVersion = input.scheduleVersion,
            confirmed = input.confirmed,
            blockNum = input.blockNum,
            producer = input.producer,
            transactionMroot = input.transactionMroot,
            id = input.id,
            actionMroot = input.actionMroot,
            timestamp = input.timestamp
        )
    }
}