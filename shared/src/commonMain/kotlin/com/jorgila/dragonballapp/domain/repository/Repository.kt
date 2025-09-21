package com.jorgila.dragonballapp.domain.repository

import com.jorgila.dragonballapp.domain.model.CharacterModel

interface Repository {
    suspend fun getAllCharacters(): List<CharacterModel>
}