package com.example.data.model.remote

import com.google.gson.annotations.SerializedName

data class BlockRemote(

	@field:SerializedName("ref_block_prefix")
	val refBlockPrefix: Long? = null,

	@field:SerializedName("previous")
	val previous: String? = null,

	@field:SerializedName("schedule_version")
	val scheduleVersion: Int? = null,

	@field:SerializedName("confirmed")
	val confirmed: Int? = null,

	@field:SerializedName("block_num")
	val blockNum: Int? = null,

	@field:SerializedName("producer")
	val producer: String? = null,

	@field:SerializedName("transaction_mroot")
	val transactionMroot: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("action_mroot")
	val actionMroot: String? = null,

	@field:SerializedName("timestamp")
	val timestamp: String? = null
)