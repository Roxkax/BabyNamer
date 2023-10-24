package com.roxkax.babynamer.di

import android.content.Context
import com.roxkax.babynamer.data.interfaces.INameProvider
import com.roxkax.babynamer.services.ApiNameProvider
import com.roxkax.babynamer.services.BabyNameApiService
import com.roxkax.babynamer.services.LocalNameProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NameProviderModule {

    @Provides
    @IntoSet
    fun provideLocalNameProvider(@ApplicationContext context: Context): INameProvider =
        LocalNameProvider(context)

    @Provides
    @IntoSet
    fun provideApiNameProvider(apiService: BabyNameApiService): INameProvider =
        ApiNameProvider(apiService)

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(client)
            .baseUrl(BabyNameApiService.BASE_URL.ifBlank { BabyNameApiService.DEFAULT_URL })
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    fun provideHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    fun provideBabyNameApiService(retrofit: Retrofit): BabyNameApiService =
        retrofit.create(BabyNameApiService::class.java)
}