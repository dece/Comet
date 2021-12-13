package dev.lowrespalmtree.comet

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [History.HistoryEntry::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyEntryDao(): History.HistoryEntryDao
}

object Database {
    lateinit var INSTANCE: AppDatabase

    fun init(context: Context) {
        if (::INSTANCE.isInitialized)
            return
        INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "comet").build()
    }
}