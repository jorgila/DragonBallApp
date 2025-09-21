package com.jorgila.dragonballapp.data.remote

import co.touchlab.kermit.Logger
import com.jorgila.dragonballapp.data.remote.response.CharactersWrapperResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(
    private val client: HttpClient
) {

    suspend fun getAllCharacters(): CharactersWrapperResponse {
        return try {
            client.get("/api/characters/"){
                parameter("limit",60)
            }.body()
        } catch (e: Exception){
            Logger.e { "Error API Services -> ${e.message}" }
            return CharactersWrapperResponse(items = emptyList())
        }
    }


}