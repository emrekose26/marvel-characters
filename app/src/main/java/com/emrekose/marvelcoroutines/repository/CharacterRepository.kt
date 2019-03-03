package com.emrekose.marvelcoroutines.repository

import com.emrekose.marvelcoroutines.data.remote.ApiService

class CharacterRepository(private val apiService: ApiService) {

    suspend fun getCharacters() = apiService.getCharacters().await()
}