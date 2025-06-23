package com.example.myprivacyhub.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myprivacyhub.model.UserProfile

@Database(entities = [UserProfile::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userProfileDao(): UserProfileDao
}
