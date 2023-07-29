package com.mashup.alcoholfree.data.di

import com.mashup.alcoholfree.data.repository.LoginRepositoryImpl
import com.mashup.alcoholfree.data.repository.MeasureRepositoryImpl
import com.mashup.alcoholfree.data.repository.PromiseRepositoryImpl
import com.mashup.alcoholfree.domain.repository.LoginRepository
import com.mashup.alcoholfree.domain.repository.MeasureRepository
import com.mashup.alcoholfree.domain.repository.PromiseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository

    @Binds
    abstract fun bindMeasureRepository(measureRepositoryImpl: MeasureRepositoryImpl): MeasureRepository

    @Binds
    abstract fun bindPromiseRepository(promiseRepositoryImpl: PromiseRepositoryImpl): PromiseRepository
}
