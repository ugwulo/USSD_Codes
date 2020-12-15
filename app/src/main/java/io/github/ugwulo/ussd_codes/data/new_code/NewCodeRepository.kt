package io.github.ugwulo.ussd_codes.data.new_code

import androidx.lifecycle.LiveData

/**
 * database mediator (observing the Repository Pattern)
 */
class NewCodeRepository(private val newCodeDao: NewCodeDao) {

    fun getSavedCodes(): LiveData<List<NewCode>> {
        return newCodeDao.getSavedCodes()
    }

    suspend fun insertNewCode(newCode: NewCode) {
        newCodeDao.insertNewCode(newCode)
    }
}