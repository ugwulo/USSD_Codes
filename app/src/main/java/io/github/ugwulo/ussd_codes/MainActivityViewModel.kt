package io.github.ugwulo.ussd_codes

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import io.github.ugwulo.ussd_codes.util.PrefsStore
import kotlinx.coroutines.launch

class MainActivityViewModel @ViewModelInject constructor(private val prefsStore: PrefsStore)
    : ViewModel() {

    val darkThemeEnabled = prefsStore.isNightMode().asLiveData()


    fun toggleNightMode() {
        viewModelScope.launch {
            prefsStore.toggleNightMode()
        }
    }
}