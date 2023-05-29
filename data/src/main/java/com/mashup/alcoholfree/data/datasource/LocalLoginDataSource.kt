package com.mashup.alcoholfree.data.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalLoginDataSource @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) {
    fun getToken(): Flow<String> {
        return dataStore
            .data
            .map {
                it[stringPreferencesKey(PREFERENCES_KEY)] ?: ""
            }
    }

    suspend fun addToken(token: String) {
        dataStore.edit {
            it[stringPreferencesKey(PREFERENCES_KEY)] = token
        }
    }

    companion object {
        private const val PREFERENCES_KEY = "token_prefs"
    }
}
