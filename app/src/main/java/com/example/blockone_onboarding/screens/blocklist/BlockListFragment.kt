package com.example.blockone_onboarding.screens.blocklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.blockone_onboarding.R
import com.example.blockone_onboarding.screens.blocklist.adapter.BlocksAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.block_list_fragment.recycler
import javax.inject.Inject

class BlockListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<BlockListViewModel> { viewModelFactory }

    private val adapter = BlocksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args: BlockListFragmentArgs by navArgs()
        viewModel.startFetchingData(args.headBlockNum)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.block_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.adapter = adapter
        viewModel.blockList.observe(viewLifecycleOwner, Observer(adapter::submitList))
    }
}