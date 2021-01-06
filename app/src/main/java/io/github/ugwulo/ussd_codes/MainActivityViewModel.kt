package io.github.ugwulo.ussd_codes

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import io.github.ugwulo.ussd_codes.util.PrefsStore
import kotlinx.coroutines.launch

/**
 * [MainActivityViewModel] class for managing Lifecycle in [MainActivity] and [OnboardingActivity]
 */
class MainActivityViewModel @ViewModelInject constructor(private val prefsStore: PrefsStore)
    : ViewModel() {

    val darkThemeEnabled = prefsStore.isNightMode().asLiveData()


    fun toggleNightMode() {
        viewModelScope.launch {
            prefsStore.toggleNightMode()
        }
    }


    val firstTimeLaunch = prefsStore.isFirstTimeLaunch().asLiveData()

    /**
     * set first time launch to true
     */
    fun setFirstTimeLaunch() {
        viewModelScope.launch {
            prefsStore.setFirstTimeLaunch()
        }
    }
}