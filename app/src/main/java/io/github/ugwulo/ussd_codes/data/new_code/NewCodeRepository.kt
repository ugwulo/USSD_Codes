package io.github.ugwulo.ussd_codes.data.new_code

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow

/**
 * database mediator (observing the Repository Pattern)
 */
class NewCodeRepository(private val newCodeDao: NewCodeDao?) {

    fun getSavedCodes(): LiveData<List<NewCode>> {
        return newCodeDao!!.getSavedCodes()
    }

    fun getDataCount(): LiveData<Int> {
        return newCodeDao!!.getDataCount()
    }

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertNewCode(newCode: NewCode) {
        newCodeDao!!.insertNewCode(newCode)
    }
}