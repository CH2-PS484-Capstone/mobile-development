package com.capstone.explorin.data.datastore


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserPreferences @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    private val ACCESS_TOKEN = stringPreferencesKey("access_token")
    private val IS_FIRST_TIME = booleanPreferencesKey("is_first_time")
    private val LOGIN_SESSION = booleanPreferencesKey("login_session")


    fun getLoginSession(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[LOGIN_SESSION] ?: false
        }
    }

    suspend fun saveLoginSession(loginSession: Boolean) {
        dataStore.edit { preferences ->
            preferences[LOGIN_SESSION] = loginSession
        }
    }

    fun getAccessToken(): Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[ACCESS_TOKEN] ?: ""
        }
    }

    suspend fun saveAccessToken(token: String) {
        dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN] = token
        }
    }

    suspend fun removeAccessToken() {
        dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN] = ""
        }
    }

    fun isFirstTime(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[IS_FIRST_TIME] ?: true
        }
    }

    suspend fun setFirstTime(firstTime: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_FIRST_TIME] = firstTime
        }
    }

}