package com.mashup.alcoholfree.data.repository

import com.mashup.alcoholfree.data.datasource.LocalLoginDataSource
import com.mashup.alcoholfree.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val localLoginDataSource: LocalLoginDataSource,
) : LoginRepository {
    override fun getToken(): Flow<String> {
        return localLoginDataSource.getToken()
    }

    override suspend fun addToken(token: String) {
        localLoginDataSource.addToken(token)
    }
}
