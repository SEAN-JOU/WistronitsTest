package com.example.wistronitstest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.wistronitstest.R
import com.example.wistronitstest.model.UserInfoData
import com.example.wistronitstest.model.UsersListModel
import com.example.wistronitstest.presenter.UsersListPresenter
import com.example.wistronitstest.view.UsersListView

class UsersListActivity : AppCompatActivity() , UsersListView{

    var presenter: UsersListPresenter? = UsersListPresenter(UsersListModel(),this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter!!.getInfo()
    }

    override fun showUsersListView(info: UserInfoData) {

        Log.d("aaaaaaccc",info.data[0].login.toString())
    }
}