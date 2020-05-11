package com.example.blockone_onboarding.di

import android.content.Context
import com.example.blockone_onboarding.BlockOneApp
import com.example.blockone_onboarding.data.di.RepositoryModule
import com.example.blockone_onboarding.screens.blocklist.BlockListModule
import com.example.blockone_onboarding.screens.di.ScreensModule
import com.example.blockone_onboarding.screens.homeblock.HomeBlockModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ScreensModule::class
    ])
interface ApplicationComponent : AndroidInjector<BlockOneApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}