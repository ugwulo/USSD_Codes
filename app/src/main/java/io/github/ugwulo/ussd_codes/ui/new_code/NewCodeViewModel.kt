package io.github.ugwulo.ussd_codes.ui.new_code

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import io.github.ugwulo.ussd_codes.NewCodeApplication
import io.github.ugwulo.ussd_codes.data.new_code.NewCode
import io.github.ugwulo.ussd_codes.data.new_code.NewCodeDatabase
import io.github.ugwulo.ussd_codes.data.new_code.NewCodeRepository
import kotlinx.coroutines.launch

/**
 * View Model to keep a reference to the NewCode repository and
 * an up-to-date list of all codes.
 */
class NewCodeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: NewCodeRepository

    init {
        val newCodeDao = NewCodeDatabase
            .getDatabase(application)
            .newCodeDao()
        repository =
            NewCodeRepository(
                newCodeDao
            )
    }

    /**
     * Launching a new coroutine to insert a new code in a non-blocking way
     */
    fun insertNewCode(newCode: NewCode) = viewModelScope.launch {
        repository.insertNewCode(newCode)
    }

    fun getSavedCodes(): LiveData<List<NewCode>> {
        return repository.getSavedCodes()
    }


    fun getDataCount(): LiveData<Int> {
        return repository.getDataCount()
    }
}

