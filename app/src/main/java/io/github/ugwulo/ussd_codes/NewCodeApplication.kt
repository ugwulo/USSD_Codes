package io.github.ugwulo.ussd_codes

import android.app.Application
import io.github.ugwulo.ussd_codes.data.new_code.NewCodeDatabase
import io.github.ugwulo.ussd_codes.data.new_code.NewCodeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NewCodeApplication: Application() {
    val repository: NewCodeRepository
    lateinit var database: NewCodeDatabase
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        val db = NewCodeDatabase.getDatabase(this)
        database = db
    }

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
//    val database by lazy { NewCodeDatabase.getDatabase(this) }
//    val repository by lazy {
//        NewCodeRepository(
//            database?.newCodeDao()
//        )
//    }

    init {
        repository = NewCodeRepository(database.newCodeDao())
    }
}