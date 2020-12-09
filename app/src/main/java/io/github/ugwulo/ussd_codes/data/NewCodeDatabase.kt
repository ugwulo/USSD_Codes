package io.github.ugwulo.ussd_codes.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [NewCode::class], exportSchema = false)
abstract class NewCodeDatabase : RoomDatabase() {

    abstract fun playerDao(): NewCodeDao

    // TODO: Add PlayerDatabaseCallback here

    companion object {

        @Volatile
        private var INSTANCE: NewCodeDatabase? = null

        fun getDatabase(context: Context): NewCodeDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    NewCodeDatabase::class.java,
                    "ussd_code_database")
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}