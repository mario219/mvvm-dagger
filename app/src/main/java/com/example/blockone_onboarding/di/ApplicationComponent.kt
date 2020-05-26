package com.example.blockone_onboarding.di

import android.content.Context
import com.example.blockone_onboarding.BlockOneApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        FrameworkDependencies::class,
        ScreensModule::class
    ])
interface ApplicationComponent : AndroidInjector<BlockOneApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}