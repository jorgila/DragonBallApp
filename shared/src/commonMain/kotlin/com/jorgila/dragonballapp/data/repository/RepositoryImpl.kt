package com.jorgila.dragonballapp.data.repository

import com.jorgila.dragonballapp.data.remote.ApiService
import com.jorgila.dragonballapp.domain.model.CharacterDetailModel
import com.jorgila.dragonballapp.domain.model.CharacterModel
import com.jorgila.dragonballapp.domain.repository.Repository

class RepositoryImpl(
    private val apiService: ApiService
) : Repository {
    override suspend fun getAllCharacters(): List<CharacterModel> {
        return apiService.getAllCharacters().items.map { characterResponse ->
            characterResponse.toDomain()
        }
    }

    override suspend fun getCharacterById(id: Int): CharacterDetailModel? {
        return apiService.getDetailCharacter(id)?.toDetailDomain()
    }

}