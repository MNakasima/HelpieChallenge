package com.mnakasima.helpiechallenge.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mnakasima.helpiechallenge.model.ApiService
import com.mnakasima.helpiechallenge.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PostViewModel: ViewModel(){

    private val postsService = ApiService()
    private val disposable = CompositeDisposable()

    val posts = MutableLiveData<List<Post>>()

    fun refresh(){

        disposable.add(
            postsService.getPosts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<Post>>() {

                    override fun onSuccess(postList: List<Post>) {
                        posts.value = postList
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