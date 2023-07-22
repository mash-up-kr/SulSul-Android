package com.mashup.alcoholfree.data.di

import com.mashup.alcoholfree.data.repository.login.LoginRepositoryImpl
import com.mashup.alcoholfree.data.repository.measure.MeasureRepositoryImpl
import com.mashup.alcoholfree.domain.repository.login.LoginRepository
import com.mashup.alcoholfree.domain.repository.measure.MeasureRepository
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
}
