package com.example.wistronitstest.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wistronitstest.R
import com.example.wistronitstest.activity.UserProfileActivity
import com.example.wistronitstest.bean.UsersListData
import com.squareup.picasso.Picasso

class UsersListAdapter(val usersListData: UsersListData, var context: Context): RecyclerView.Adapter<UsersListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = usersListData.data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var userInfo = usersListData.data[position]
        holder.titleView.text = userInfo.login
//        holder.typeView.text = userInfo.type
        Picasso.with(context).load(userInfo.avatar_url).placeholder(R.mipmap.ic_launcher_round).into(holder.headImageView)
        if(userInfo.site_admin!!.toBoolean()){
            holder.typeView.visibility = View.VISIBLE
        }else{
            holder.typeView.visibility = View.GONE
        }
        holder.linearLayout.setOnClickListener{
            val it = Intent(context, UserProfileActivity::class.java)
            it.putExtra("Username", userInfo.login)
            context.startActivity(it)
        }
    }

    class ViewHolder(val view: View) :  RecyclerView.ViewHolder(view) {
        val titleView = view.findViewById<TextView>(R.id.titleView)
        val headImageView = view.findViewById<ImageView>(R.id.headImageView)
        val typeView = view.findViewById<TextView>(R.id.typeView)
        val linearLayout = view.findViewById<LinearLayout>(R.id.linearLayout)
    }
}