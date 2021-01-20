package nigeria.network.ussd.bank.cod.ui.new_code

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import nigeria.network.ussd.bank.cod.data.new_code.NewCode
import nigeria.network.ussd.bank.cod.data.new_code.NewCodeDatabase
import nigeria.network.ussd.bank.cod.data.new_code.NewCodeRepository
import kotlinx.coroutines.launch

/**
 * View Model to keep a reference to the NewCode repository and
 * an up-to-date list of all codes.
 */
class NewCodeViewModel @ViewModelInject constructor(application: Application)
    : AndroidViewModel(application) {
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

