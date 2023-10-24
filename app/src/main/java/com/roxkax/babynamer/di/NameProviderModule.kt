package com.roxkax.babynamer.di

import android.content.Context
import com.roxkax.babynamer.data.interfaces.INameProvider
import com.roxkax.babynamer.services.ApiNameProvider
import com.roxkax.babynamer.services.LocalNameProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NameProviderModule {
    @Provides
    @IntoSet
    fun provideLocalNameProvider(@ApplicationContext context: Context): INameProvider =
        LocalNameProvider(context)

    @Provides
    @IntoSet
    fun provideApiNameProvider(@ApplicationContext context: Context): INameProvider =
        ApiNameProvider()
}