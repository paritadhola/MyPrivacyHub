package com.example.myprivacyhub.screens

import com.example.myprivacyhub.utils.BiometricHelper.isBiometricAvailable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.example.myprivacyhub.utils.BiometricHelper

@Composable
fun LoginScreen(navController: NavController, activity: FragmentActivity) {
    var errorText by remember { mutableStateOf<String?>(null) }
    val biometricAvailable = remember { isBiometricAvailable(activity) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to MyPrivacy Hub", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(32.dp))

        if (biometricAvailable) {
            Button(onClick = {
                BiometricHelper.showBiometricPrompt(
                    activity,
                    onSuccess = { navController.navigate("consent") },
                    onError = { errorText = it }
                )
            }) {
                Text("Login with Biometrics")
            }
        } else {
            Text("Biometric login not available or not set up.")
        }


        errorText?.let {
            Spacer(Modifier.height(16.dp))
            Text("⚠️ $it", color = Color.Red)
        }
    }
}
