package com.mnakasima.helpiechallenge.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mnakasima.helpiechallenge.model.Post

class PostViewModel: ViewModel(){

    val posts = MutableLiveData<List<Post>>()

    fun refresh(){

        val post1 = Post("1","sunt aut facere repellat provident occaecati excepturi optio reprehenderit","quia et suscipitnsuscipit recusandae consequuntur expedita et cumnreprehenderit molestiae ut ut quas totamnnostrum rerum est autem sunt rem eveniet architecto")
        val post2 = Post("2","qui est esse","est rerum tempore vitaensequi sint nihil reprehenderit dolor beatae ea dolores nequenfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendisnqui aperiam non debitis possimus qui neque nisi nulla")

        val postList = arrayListOf<Post>(post1,post2)

        posts.value = postList
    }


}