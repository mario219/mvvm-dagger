package com.example.blockone_onboarding.screens.blocklist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.blockone_onboarding.databinding.BlockItemBinding
import com.example.blockone_onboarding.screens.blocklist.BlockListFragmentDirections
import com.example.domain.model.Block

class BlockViewHolder(
    private val binding: BlockItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(block: Block?) {
        block?.run {
            binding.block = block
            binding.executePendingBindings()
        }

        binding.block?.blockNum?.run {
            itemView.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                    BlockListFragmentDirections.actionOpenDetail(this)
                )
            )
        }
    }

    companion object {
        fun from(parent: ViewGroup): BlockViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = BlockItemBinding.inflate(layoutInflater, parent, false)

            return BlockViewHolder(binding)
        }
    }
}