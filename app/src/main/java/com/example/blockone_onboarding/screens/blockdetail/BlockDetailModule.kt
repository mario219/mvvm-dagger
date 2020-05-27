package com.example.blockone_onboarding.screens.blockdetail

import androidx.lifecycle.ViewModel
import com.example.blockone_onboarding.di.ViewModelBuilderModule
import com.example.blockone_onboarding.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class BlockDetailModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilderModule::class])
    internal abstract fun blockListFragment(): BlockDetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(BlockDetailViewModel::class)
    abstract fun bindViewModel(viewModel: BlockDetailViewModel): ViewModel
}