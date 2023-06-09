package com.mashup.alcoholfree.domain.repository

import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun getToken(): Flow<String>
    suspend fun addToken(token: String)
}
