package com.mnakasima.helpiechallenge.model

import com.google.gson.annotations.SerializedName

data class Post(

    @SerializedName("title")
    val postTitle:String?,

    @SerializedName("body")
    val postText:String?
)