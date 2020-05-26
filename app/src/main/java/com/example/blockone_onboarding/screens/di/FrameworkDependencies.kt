package com.example.blockone_onboarding.screens.di

import android.content.Context
import android.content.SharedPreferences
import com.example.blockone_onboarding.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FrameworkDependencies {

    @Provides
    @Singleton
    fun providesSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(BuildConfig.PREFS, Context.MODE_PRIVATE)
    }
}