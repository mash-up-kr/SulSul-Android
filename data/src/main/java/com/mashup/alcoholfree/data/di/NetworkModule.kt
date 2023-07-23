package com.mashup.alcoholfree.data.di

import com.mashup.alcoholfree.data.BuildConfig
import com.mashup.alcoholfree.data.datasource.LocalLoginDataSource
import com.mashup.alcoholfree.data.service.SulSulService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Singleton
    @Provides
    fun provideAuthInterceptor(loginDataSource: LocalLoginDataSource): Interceptor {
        return Interceptor { chain ->
            val authToken = runBlocking {
                loginDataSource.getToken().first()
            }
            chain.proceed(
                chain.request()
                    .newBuilder()
                    .addHeader("Authorization", "Bearer $authToken")
                    .build(),
            )
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(
                TIME_OUT_POLICY,
                TimeUnit.MILLISECONDS,
            )
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideMeasureService(retrofit: Retrofit): SulSulService =
        retrofit.create(SulSulService::class.java)

    companion object {
        private const val BASE_URL = "https://sulsul.app"
        private const val TIME_OUT_POLICY = 10_000L
    }
}
