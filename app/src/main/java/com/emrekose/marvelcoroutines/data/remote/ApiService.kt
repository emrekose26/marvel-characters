package com.emrekose.marvelcoroutines.data.remote

import com.emrekose.marvelcoroutines.model.characters.CharacterResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("v1/public/characters")
    fun getCharacters(): Deferred<Response<CharacterResponse>>
}