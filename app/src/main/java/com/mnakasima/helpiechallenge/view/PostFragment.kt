package com.mnakasima.helpiechallenge.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.Observer
import com.mnakasima.helpiechallenge.R
import com.mnakasima.helpiechallenge.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.fragment_post.*

/**
 * A simple [Fragment] subclass.
 */
class PostFragment : Fragment() {

    private lateinit var viewModel: PostViewModel
    private val postsListAdapter = PostListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        viewModel.refresh()

        postsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = postsListAdapter
        }
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.posts.observe(this, Observer {posts ->
            posts?.let {
                postsList.visibility = View.VISIBLE
                postsListAdapter.updatePostList(posts)
            }
        })

    }


}
