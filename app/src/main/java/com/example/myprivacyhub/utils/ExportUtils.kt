package com.example.myprivacyhub.utils


import android.content.Context
import android.os.Environment
import com.example.myprivacyhub.model.ExportData
import com.google.gson.Gson
import java.io.File

fun exportToJson(context: Context, exportData: ExportData): File? {
    return try {
        val gson = Gson()
        val jsonString = gson.toJson(exportData)

        val fileName = "privacy_backup_${System.currentTimeMillis()}.json"
        val dir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val file = File(dir, fileName)
        file.writeText(jsonString)

        file
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
