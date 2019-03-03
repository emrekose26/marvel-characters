package com.emrekose.marvelcoroutines.model.characters

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("data")
    var data: CharacterData
)