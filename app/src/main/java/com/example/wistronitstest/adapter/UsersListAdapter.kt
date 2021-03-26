package com.example.wistronitstest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wistronitstest.R
import com.example.wistronitstest.model.Repository
import kotlinx.android.extensions.LayoutContainer

class UsersListAdapter(private val repositories: MutableList<Repository>,private val onClick: (Repository) -> Unit): RecyclerView.Adapter<UsersListAdapter.ViewHolder>(){


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(repositories[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false).let {
                ViewHolder(it, onClick)
            }
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    class ViewHolder(override val containerView: View, private val onClick: (Repository) -> Unit) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindData(repository: Repository) {
            with(repository) {
                containerView.setOnClickListener { onClick(this) }
            }
        }
    }

    fun addRepositories(newRepositories: List<Repository>) {
        repositories.addAll(newRepositories)
    }
}