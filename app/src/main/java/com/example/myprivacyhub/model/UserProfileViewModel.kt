package com.example.myprivacyhub.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.myprivacyhub.data.DatabaseProvider
import com.example.myprivacyhub.model.UserProfile
import kotlinx.coroutines.launch

class UserProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = DatabaseProvider.getDatabase(application).userProfileDao()

    private val _profile = MutableLiveData<UserProfile?>()
    val profile: LiveData<UserProfile?> = _profile

    fun loadProfile() = viewModelScope.launch {
        _profile.value = dao.getProfile()
    }

    fun saveProfile(name: String, email: String) = viewModelScope.launch {
        val profile = UserProfile(name = name, email = email)
        dao.upsertProfile(profile)
        _profile.value = profile
    }
}
