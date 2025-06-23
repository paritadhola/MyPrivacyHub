package com.example.myprivacyhub.model

import android.app.Application
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myprivacyhub.utils.PrivacyPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConsentViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

    val consentFlow = PrivacyPreferences.preferencesFlow(application)

    fun toggleConsent(key: Preferences.Key<Boolean>, value: Boolean) {
        viewModelScope.launch {
            PrivacyPreferences.updateConsent(getApplication(), key, value)
        }
    }
}