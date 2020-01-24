package com.mnakasima.helpiechallenge.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mnakasima.helpiechallenge.model.ApiService
import com.mnakasima.helpiechallenge.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class UserViewModel: ViewModel(){

    private val usersService = ApiService()
    private val disposable = CompositeDisposable()

    val users = MutableLiveData<List<User>>()

    fun refresh(){

        disposable.add(
            usersService.getUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<User>>() {

                    override fun onSuccess(userList: List<User>) {
                        users.value = userList
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )

    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}