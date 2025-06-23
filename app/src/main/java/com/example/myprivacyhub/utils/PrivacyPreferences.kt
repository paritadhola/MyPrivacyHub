package com.example.myprivacyhub.utils

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.example.myprivacyhub.screens.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

object PrivacyPreferences {

    // Preference keys
    val LOCATION = booleanPreferencesKey("consent_location")
    val ANALYTICS = booleanPreferencesKey("consent_analytics")

    // Update a preference value
    suspend fun updateConsent(context: Context, key: Preferences.Key<Boolean>, value: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[key] = value
        }
    }

    // Flow to observe preferences
    fun preferencesFlow(context: Context): Flow<Map<String, Boolean>> =
        context.dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else throw exception
            }
            .map { prefs ->
                mapOf(
                    "location" to (prefs[LOCATION] ?: false),
                    "analytics" to (prefs[ANALYTICS] ?: false)
                )
            }
}