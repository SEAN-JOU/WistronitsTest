package com.example.wistronitstest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wistronitstest.R
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
        Picasso.with(context).load(userInfo.avatar_url).placeholder(R.mipmap.ic_launcher_round).into(holder.imageView)
//
//        holder.linearlayout.setOnClickListener{
//            val it = Intent(context.activity, ReadPhotoActivity::class.java)
//            it.putExtra("PhotoUrl", blueprintDetailDataType.BlueprintVersion.get(position).BlueprintUrl)
//            context.startActivity(it)
//        }
    }

    class ViewHolder(val view: View) :  RecyclerView.ViewHolder(view) {
        val titleView = view.findViewById<TextView>(R.id.title_view)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
    }


}