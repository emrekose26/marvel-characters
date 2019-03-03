package com.emrekose.marvelcoroutines.model.characters

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterThumbnail(
    @SerializedName("path")
    var path: String,

    @SerializedName("extension")
    var extension: String
) : Parcelable