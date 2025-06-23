package com.example.myprivacyhub.screens

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

// Extension to create DataStore instance
private val Context.dataStore by preferencesDataStore(name = "privacy_prefs")

