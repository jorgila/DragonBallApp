package com.jorgila.dragonballapp.data.remote.response

import com.jorgila.dragonballapp.domain.model.CharacterDetailModel
import com.jorgila.dragonballapp.domain.model.CharacterModel
import com.jorgila.dragonballapp.domain.model.OriginPlanetModel
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val id: Int,
    val name: String,
    val ki: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String,
    val originPlanet: OriginResponse? = null,
    val transformations: List<TransformationResponse>? = emptyList()
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

    fun toDetailDomain(): CharacterDetailModel? {
        if (originPlanet == null) return null
        return CharacterDetailModel(
            characterModel = CharacterModel(
                id = id,
                name = name,
                ki = ki,
                race = race,
                gender = gender,
                description = description,
                image = image
            ),
            originModel = OriginPlanetModel(
                name = originPlanet.name,
                isDestroyed = originPlanet.isDestroyed,
                description = originPlanet.description,
                image = originPlanet.image
            ),
            transformations = transformations?.map { it.toDomain() } ?: emptyList()
            )
    }
}