package com.example.blockone_onboarding.screens.blocklist.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.Block

class BlocksAdapter : PagedListAdapter<Block, BlockViewHolder>(diffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BlockViewHolder.from(parent)

    override fun onBindViewHolder(holder: BlockViewHolder, position: Int) {
        holder.bind(getItem(position))
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