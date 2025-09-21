package com.jorgila.dragonballapp.data.remote.response

import com.jorgila.dragonballapp.domain.model.TransformationModel
import kotlinx.serialization.Serializable

@Serializable
data class TransformationResponse(
    val name: String,
    val image: String,
    val ki: String
) {
    fun toDomain(): TransformationModel {
        return TransformationModel(
            name = name,
            image = image,
            ki = ki
        )
    }
}
