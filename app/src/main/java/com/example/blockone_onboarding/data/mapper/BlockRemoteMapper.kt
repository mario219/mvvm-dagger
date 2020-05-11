package com.example.blockone_onboarding.data.mapper

import com.example.blockone_onboarding.data.model.remote.BlockRemote
import com.example.blockone_onboarding.domain.model.Block
import javax.inject.Inject

class BlockRemoteMapper @Inject constructor() : BaseRemoteMapper<BlockRemote, Block> {

    override fun transform(input: BlockRemote): Block {
        TODO("Not yet implemented")
    }
}