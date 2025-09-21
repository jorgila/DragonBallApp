package com.jorgila.dragonballapp.domain.repository

import com.jorgila.dragonballapp.domain.model.CharacterDetailModel
import com.jorgila.dragonballapp.domain.model.CharacterModel

interface Repository {
    suspend fun getAllCharacters(): List<CharacterModel>
    suspend fun getCharacterById(id: Int): CharacterDetailModel?
}