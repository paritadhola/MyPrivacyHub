package com.example.myprivacyhub.model


data class ExportData(
    val name: String,
    val email: String,
    val locationConsent: Boolean,
    val analyticsConsent: Boolean
)

