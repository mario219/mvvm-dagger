package com.example.blockone_onboarding.data.mapper

import com.example.blockone_onboarding.data.model.local.BlockLocal
import com.example.blockone_onboarding.domain.model.Block
import javax.inject.Inject

class BlockLocalMapper @Inject constructor() : BaseMapper<BlockLocal, Block> {

    override fun transform(input: BlockLocal): Block {
        TODO("Not yet implemented")
    }

    override fun transformToEntity(input: Block): BlockLocal {
        TODO("Not yet implemented")
    }
}