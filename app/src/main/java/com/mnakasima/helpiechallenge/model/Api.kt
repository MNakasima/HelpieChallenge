package com.mnakasima.helpiechallenge.model

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Api {

    @GET("users")
    fun getUsers(): Single<List<User>>


    @GET("posts")
    fun getPosts(@Query("userId") id: String?):Single<List<Post>>


    @GET("photos")
    fun getPhotos(): Single<List<Image>>


}