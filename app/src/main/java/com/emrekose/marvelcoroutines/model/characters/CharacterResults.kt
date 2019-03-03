package com.emrekose.marvelcoroutines.model.characters

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterResults(
    @SerializedName("id")
    var characterId: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("thumbnail")
    var thumbnail: CharacterThumbnail
) : Parcelable