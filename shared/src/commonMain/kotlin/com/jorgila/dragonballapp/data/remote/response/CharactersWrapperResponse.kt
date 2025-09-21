package com.jorgila.dragonballapp.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class CharactersWrapperResponse(
    val items: List<CharacterResponse>
)
