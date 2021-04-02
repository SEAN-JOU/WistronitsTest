package com.example.wistronitstest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wistronitstest.R
import com.example.wistronitstest.adapter.UsersListAdapter
import com.example.wistronitstest.bean.UsersListData
import com.example.wistronitstest.model.UsersListModel
import com.example.wistronitstest.presenter.UsersListPresenter
import com.example.wistronitstest.view.UsersListView
import kotlinx.android.synthetic.main.activity_main.*

class UsersListActivity : AppCompatActivity() , UsersListView{

    var usersListAdapter : UsersListAdapter? = null
    var presenter: UsersListPresenter? = UsersListPresenter(UsersListModel(),this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter!!.getInfo()
    }

    override fun showUsersListView(usersListData: UsersListData) {
        usersListAdapter = UsersListAdapter(usersListData, this)
        runOnUiThread {
            usersListRecyclerView.layoutManager = LinearLayoutManager(this)
            usersListRecyclerView.adapter = usersListAdapter
        }
        Log.d("aaaaaaccc",usersListData.data[0].login.toString())
    }
}