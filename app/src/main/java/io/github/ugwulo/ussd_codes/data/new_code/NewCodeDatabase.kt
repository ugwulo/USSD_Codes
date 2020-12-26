package io.github.ugwulo.ussd_codes.data.new_code

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * database class
 */
@Database(entities = [NewCode::class], version = 1, exportSchema = true)
abstract class NewCodeDatabase : RoomDatabase() {

    abstract fun newCodeDao(): NewCodeDao

    companion object {

        @Volatile
        private var INSTANCE: NewCodeDatabase? = null

        fun getDatabase(context: Context
        ): NewCodeDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    NewCodeDatabase::class.java,
                    "ussd_code_db")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}