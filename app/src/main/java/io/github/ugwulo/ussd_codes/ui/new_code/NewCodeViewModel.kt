package io.github.ugwulo.ussd_codes.ui.new_code

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.ugwulo.ussd_codes.data.new_code.NewCode
import io.github.ugwulo.ussd_codes.data.new_code.NewCodeDatabase
import io.github.ugwulo.ussd_codes.data.new_code.NewCodeRepository
import kotlinx.coroutines.launch

class NewCodeViewModel(application: Application): ViewModel() {
    private val newCodeRepository: NewCodeRepository

    init {
        val newCodeDao = NewCodeDatabase
            .getDatabase(application)
            .newCodeDao()
        newCodeRepository =
            NewCodeRepository(
                newCodeDao
            )
    }

    fun insertNewCode(newCode: NewCode) = viewModelScope.launch {
        newCodeRepository.insertNewCode(newCode)
    }
    fun getSavedCodes(): LiveData<List<NewCode>> {
        return newCodeRepository.getSavedCodes()
    }
}