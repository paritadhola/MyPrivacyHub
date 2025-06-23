package com.example.myprivacyhub.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myprivacyhub.model.ConsentViewModel
import com.example.myprivacyhub.model.ExportData
import com.example.myprivacyhub.utils.PrivacyPreferences
import com.example.myprivacyhub.utils.exportToJson

@Composable
fun ConsentScreen(viewModel: ConsentViewModel = hiltViewModel()) {
    val consentPrefs by viewModel.consentFlow.collectAsState(initial = emptyMap())

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Manage Your Consents", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        RowToggle("Location Access", consentPrefs["location"] == true) {
            viewModel.toggleConsent(PrivacyPreferences.LOCATION, it)
        }

        RowToggle("App Analytics", consentPrefs["analytics"] == true) {
            viewModel.toggleConsent(PrivacyPreferences.ANALYTICS, it)
        }
        val context = LocalContext.current

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            val exportData = ExportData(
                name = "Parita Dhola",  // You can make this dynamic later
                email = "dholaparita@gmail.com",
                locationConsent = consentPrefs["location"] == true,
                analyticsConsent = consentPrefs["analytics"] == true
            )

            val file = exportToJson(context, exportData)
            if (file != null) {
                Toast.makeText(context, "Exported to ${file.absolutePath}", Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast.makeText(context, "Export failed", Toast.LENGTH_LONG).show()
            }
        }) {
            Text("Export to JSON")
        }

    }
}

@Composable
fun RowToggle(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label)
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}