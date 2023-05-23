package com.mashup.alcoholfree.data.di

import com.mashup.alcoholfree.data.repository.DataStoreRepositoryImpl
import com.mashup.alcoholfree.domain.repository.DataStoreRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindDataStoreRepository(dataStoreRepositoryImpl: DataStoreRepositoryImpl): DataStoreRepository
}
