package com.mnakasima.helpiechallenge.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mnakasima.helpiechallenge.R
import com.mnakasima.helpiechallenge.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostListAdapter(val postsList: ArrayList<Post>):RecyclerView.Adapter<PostListAdapter.PostViewHolder>(){

    fun updatePostList(newPostsList: List<Post>){
        postsList.clear()
        postsList.addAll(newPostsList)
        notifyDataSetChanged()
    }

    class PostViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount() = postsList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.view.title.text = postsList[position].postTitle
        holder.view.text.text = postsList[position].postText
    }

}