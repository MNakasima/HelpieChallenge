package com.mnakasima.helpiechallenge.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.mnakasima.helpiechallenge.R
import com.mnakasima.helpiechallenge.model.User
import kotlinx.android.synthetic.main.item_user.view.*

class UsersListAdapter(val usersList: ArrayList<User>):RecyclerView.Adapter<UsersListAdapter.UserViewHolder>(){

    fun updateUserList(newUsersList: List<User>){
        usersList.clear()
        usersList.addAll(newUsersList)
        notifyDataSetChanged()
    }

    class UserViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount() = usersList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.view.userid.text = usersList[position].userId
        holder.view.name.text = usersList[position].userName
        holder.view.email.text = usersList[position].userEmail
        holder.view.company.text = usersList[position].userCompany
        holder.view.city.text = usersList[position].userCity

        holder.view.setOnClickListener{
            Navigation.findNavController(it).navigate(UserFragmentDirections.actionPostFragment())
        }
    }

}