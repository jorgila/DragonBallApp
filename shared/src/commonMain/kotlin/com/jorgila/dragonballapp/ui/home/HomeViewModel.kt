package com.jorgila.dragonballapp.ui.home

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private val _example = MutableStateFlow<String>(viewModelScope,"Pepe")
    @NativeCoroutinesState
    val example: StateFlow<String> = _example
}