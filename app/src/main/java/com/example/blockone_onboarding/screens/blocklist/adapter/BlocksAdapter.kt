package com.example.blockone_onboarding.screens.blocklist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.blockone_onboarding.R
import com.example.blockone_onboarding.domain.model.Block

class BlocksAdapter : PagedListAdapter<Block, BlocksAdapter.BlockViewHolder>(diffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockViewHolder {
        return BlockViewHolder(parent)
    }

    override fun onBindViewHolder(holder: BlockViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BlockViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.block_item, parent, false)
    ) {
        private var block: Block? = null
        private val producer = itemView.findViewById<TextView>(R.id.text_producer)
        private val blockNum = itemView.findViewById<TextView>(R.id.text_block_num)
        private val timestamp = itemView.findViewById<TextView>(R.id.text_timestamp)

        fun bind(block: Block?) {
            this.block = block
            producer.text = block?.producer
            blockNum.text = block?.blockNum.toString()
            timestamp.text = block?.timestamp
        }
    }

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<Block>() {
            override fun areItemsTheSame(oldItem: Block, newItem: Block): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Block, newItem: Block): Boolean =
                oldItem == newItem
        }
    }
}