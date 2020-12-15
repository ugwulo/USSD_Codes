package io.github.ugwulo.ussd_codes.data.new_code

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * database class
 */
@Database(entities = [NewCode::class], version = 1)
abstract class NewCodeDatabase : RoomDatabase() {

    abstract fun newCodeDao(): NewCodeDao

    // TODO: Add NewCodeDatabaseCallback here

    companion object {

        @Volatile
        private var INSTANCE: NewCodeDatabase? = null

        fun getDatabase(context: Context): NewCodeDatabase {
            val tempInstance =
                INSTANCE
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