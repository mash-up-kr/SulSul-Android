package com.mashup.alcoholfree.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    fun getToken(): Flow<String>
    suspend fun addToken(token: String)
}
