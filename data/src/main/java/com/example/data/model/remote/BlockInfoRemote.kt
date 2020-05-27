package com.example.blockone_onboarding.data.model.remote

import com.google.gson.annotations.SerializedName

data class BlockInfoRemote(

	@field:SerializedName("head_block_num")
	val headBlockNum: Int? = null,

	@field:SerializedName("fork_db_head_block_num")
	val forkDbHeadBlockNum: Int? = null,

	@field:SerializedName("chain_id")
	val chainId: String? = null,

	@field:SerializedName("head_block_time")
	val headBlockTime: String? = null,

	@field:SerializedName("virtual_block_net_limit")
	val virtualBlockNetLimit: Int? = null,

	@field:SerializedName("virtual_block_cpu_limit")
	val virtualBlockCpuLimit: Int? = null,

	@field:SerializedName("last_irreversible_block_num")
	val lastIrreversibleBlockNum: Int? = null,

	@field:SerializedName("server_version")
	val serverVersion: String? = null,

	@field:SerializedName("block_cpu_limit")
	val blockCpuLimit: Int? = null,

	@field:SerializedName("head_block_producer")
	val headBlockProducer: String? = null,

	@field:SerializedName("fork_db_head_block_id")
	val forkDbHeadBlockId: String? = null,

	@field:SerializedName("last_irreversible_block_id")
	val lastIrreversibleBlockId: String? = null,

	@field:SerializedName("block_net_limit")
	val blockNetLimit: Int? = null,

	@field:SerializedName("head_block_id")
	val headBlockId: String? = null,

	@field:SerializedName("server_full_version_string")
	val serverFullVersionString: String? = null,

	@field:SerializedName("server_version_string")
	val serverVersionString: String? = null
)
