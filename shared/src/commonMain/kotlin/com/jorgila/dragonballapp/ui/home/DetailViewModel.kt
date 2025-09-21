package com.jorgila.dragonballapp.ui.home

import com.jorgila.dragonballapp.domain.model.CharacterDetailModel
import com.jorgila.dragonballapp.domain.repository.Repository
import com.rickclephas.kmp.nativecoroutines.NativeCoroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val id: Int,
    private val repository: Repository,
) : ViewModel() {
    private val _character = MutableStateFlow<CharacterDetailModel?>(viewModelScope,null)
    @NativeCoroutinesState
    val character: StateFlow<CharacterDetailModel?> = _character

    init {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                repository.getCharacterById(id)
            }
            if(response!=null){
                _character.value = response
            }
        }
    }

}