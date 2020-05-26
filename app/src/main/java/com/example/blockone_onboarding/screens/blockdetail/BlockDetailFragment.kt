package com.example.blockone_onboarding.screens.blockdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.blockone_onboarding.databinding.BlockDetailFragmentBinding
import com.example.blockone_onboarding.domain.model.Block
import com.example.blockone_onboarding.util.hideActionBar
import com.example.blockone_onboarding.util.showActionBar
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class BlockDetailFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<BlockDetailViewModel> { viewModelFactory }

    private lateinit var detailFragmentBinding: BlockDetailFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args: BlockDetailFragmentArgs by navArgs()
        viewModel.getBlockDetail(args.blockNum)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.hideActionBar()
        setHasOptionsMenu(false)
        detailFragmentBinding =
            BlockDetailFragmentBinding.inflate(inflater, container, false)
        return detailFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.blockDetail.observe(
            viewLifecycleOwner,
            Observer(::loadBlockDetailData)
        )
    }

    private fun loadBlockDetailData(block: Block) {
        detailFragmentBinding.block = block
        detailFragmentBinding.imgClose.setOnClickListener(
            Navigation
                .createNavigateOnClickListener(BlockDetailFragmentDirections.actionClose())
        )
        detailFragmentBinding.executePendingBindings()
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.showActionBar()
    }
}