package com.example.blockone_onboarding.screens.blocklist

import androidx.lifecycle.ViewModel
import com.example.blockone_onboarding.di.ViewModelBuilderModule
import com.example.blockone_onboarding.domain.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class BlockListModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilderModule::class])
    internal abstract fun blockListFragment(): BlockListFragment

    @Binds
    @IntoMap
    @ViewModelKey(BlockListViewModel::class)
    abstract fun bindViewModel(viewModel: BlockListViewModel): ViewModel
}