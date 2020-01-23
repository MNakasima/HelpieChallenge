package com.mnakasima.helpiechallenge.model

import io.reactivex.Single
import retrofit2.http.GET

interface Api {

    @GET("users")
    fun getUsers(): Single<List<User>>

    @GET("posts?userId=1")
    fun getPosts():Single<List<Post>>

}