package com.example.myprivacyhub.screens

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myprivacyhub.viewmodel.UserProfileViewModel
import com.example.myprivacyhub.viewmodel.UserProfileViewModelFactory

@Composable
fun ProfileScreen(activity: Activity) {
    val context = LocalContext.current
    val application = activity.application
    val factory = remember { UserProfileViewModelFactory(application) }
    val viewModel: UserProfileViewModel = viewModel(factory = factory)

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val profile = viewModel.profile.observeAsState()

    LaunchedEffect(true) {
        viewModel.loadProfile()
    }

    LaunchedEffect(profile.value) {
        profile.value?.let {
            name = it.name
            email = it.email
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("User Profile", style = MaterialTheme.typography.headlineSmall)

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { viewModel.saveProfile(name, email) },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }
    }
}
