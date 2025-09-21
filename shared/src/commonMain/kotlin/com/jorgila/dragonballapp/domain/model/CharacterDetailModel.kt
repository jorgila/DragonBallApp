package com.jorgila.dragonballapp.domain.model

data class CharacterDetailModel(
    val characterModel: CharacterModel,
    val originModel: OriginPlanetModel,
    val transformations: List<TransformationModel>
)