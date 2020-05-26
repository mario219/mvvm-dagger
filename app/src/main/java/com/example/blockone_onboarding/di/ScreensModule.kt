package com.example.blockone_onboarding.di

import com.example.blockone_onboarding.screens.MainActivity
import com.example.blockone_onboarding.screens.blockdetail.BlockDetailModule
import com.example.blockone_onboarding.screens.blocklist.BlockListModule
import com.example.blockone_onboarding.screens.homeblock.HomeBlockModule
import com.example.data.di.RepositoryModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Include here the fragmentModule set that integrates the host,
 * also include here the dependency module for this feature
 */
@Module(includes = [
    HomeBlockModule::class,
    BlockListModule::class,
    BlockDetailModule::class,
    RepositoryModule::class
])
/**
 * Represent a consolidate of features or just a feature of the app
 * For this example we are calling it just ScreensModule
 */
abstract class ScreensModule {

    /**
     *  Activity that hosts all fragments in this example
     *  You can configure as many module as you want for activity hosting its fragments
     */
    @ContributesAndroidInjector(modules = [ViewModelBuilderModule::class])
    internal abstract fun mainActivity(): MainActivity
}