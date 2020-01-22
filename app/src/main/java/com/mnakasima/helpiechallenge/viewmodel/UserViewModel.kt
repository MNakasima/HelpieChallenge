package com.mnakasima.helpiechallenge.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mnakasima.helpiechallenge.model.User

class UserViewModel: ViewModel(){

    val users = MutableLiveData<List<User>>()

    fun refresh(){

        val user1 = User("1","Marco","blabla@blabla","Home","SP")
        val user2 = User("2","Hideki","bla@blabla","MyTrace","SCS")
        val user3 = User("3","Fred","blabla@bla","ACI","SP")

        val userList = arrayListOf<User>(user1,user2,user3)

        users.value = userList
    }


}