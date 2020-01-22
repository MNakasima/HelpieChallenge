package com.mnakasima.helpiechallenge.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.mnakasima.helpiechallenge.R
import com.mnakasima.helpiechallenge.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_user.*

/**
 * A simple [Fragment] subclass.
 */
class UserFragment : Fragment() {

    private lateinit var viewModel: UserViewModel
    private val usersListAdapter = UsersListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        viewModel.refresh()

        usersList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = usersListAdapter
        }
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.users.observe(this, Observer {users ->
            users?.let {
                usersList.visibility = View.VISIBLE
                usersListAdapter.updateUserList(users)
            }
        })

    }

}
