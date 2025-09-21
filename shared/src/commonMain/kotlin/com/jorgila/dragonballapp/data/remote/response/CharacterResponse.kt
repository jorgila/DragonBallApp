package com.jorgila.dragonballapp.data.remote.response

import com.jorgila.dragonballapp.domain.model.CharacterModel
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val id: Int,
    val name: String,
    val ki: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id,
            name = name,
            ki = ki,
            race = race,
            gender = gender,
            description = description,
            image = image
        )

    }
}