package com.example.blockone_onboarding.screens.homeblock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.blockone_onboarding.R
import com.example.blockone_onboarding.utils.MSG_ERROR_BTN_HOME
import com.example.domain.utils.EMPTY_STRING
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeBlockFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<HomeBlockViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.clearCachedData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.home_block_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewListeners()
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchBlockInfo()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clearCachedData()
    }

    private fun initViewListeners() {
        viewModel.blockNumInfo.observe(viewLifecycleOwner, Observer {
            if (it == EMPTY_STRING) {
                view?.findViewById<Button>(R.id.btn_fetch_blocks)?.setOnClickListener {
                    viewModel.retryFetchingBlockInfo()
                    Toast.makeText(context, MSG_ERROR_BTN_HOME, Toast.LENGTH_SHORT).show()
                }
            } else {
                view?.findViewById<Button>(R.id.btn_fetch_blocks)?.setOnClickListener(
                    Navigation
                        .createNavigateOnClickListener(HomeBlockFragmentDirections.actionFetchBlocks(it))
                )
            }
        })
    }
}