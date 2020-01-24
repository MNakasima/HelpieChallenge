package com.mnakasima.helpiechallenge.model

import com.google.gson.annotations.SerializedName

data class Image(

    @SerializedName("url")
    val imageUrl:String?,

    @SerializedName("thumbnailUrl")
    val thumbUrl:String?

    )