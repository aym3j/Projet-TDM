package com.example.projet_tdm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.projet_tdm.database.arret.Arret
import com.example.projet_tdm.database.arret.ArretDao

@Database(entities = [Arret::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun scheduleDao(): ArretDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, "app_database"
                ).build()

                INSTANCE = instance

                instance
            }
        }
    }
}