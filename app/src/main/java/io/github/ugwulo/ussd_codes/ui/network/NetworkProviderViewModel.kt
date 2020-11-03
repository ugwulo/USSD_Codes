package io.github.ugwulo.ussd_codes.ui.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NetworkProviderViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is NetworkProvider Fragment"
    }
    val text: LiveData<String> = _text
}