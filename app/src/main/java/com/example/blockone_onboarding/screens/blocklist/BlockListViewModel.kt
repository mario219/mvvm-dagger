package com.example.blockone_onboarding.screens.blocklist

import androidx.lifecycle.ViewModel
import com.example.blockone_onboarding.domain.repository.BlockRepository
import javax.inject.Inject

class BlockListViewModel @Inject constructor(
    private val blockRepository: BlockRepository
) : ViewModel() {

}