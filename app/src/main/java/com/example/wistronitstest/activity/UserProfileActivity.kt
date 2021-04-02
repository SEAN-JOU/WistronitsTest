package com.example.wistronitstest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.wistronitstest.R
import com.example.wistronitstest.api.ApiManager
import com.example.wistronitstest.bean.UserProfileData
import com.example.wistronitstest.model.UserProfileModel
import com.example.wistronitstest.model.UsersListModel
import com.example.wistronitstest.presenter.UserProfilePresenter
import com.example.wistronitstest.presenter.UsersListPresenter
import com.example.wistronitstest.view.UserProfileView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user_profile.*

class UserProfileActivity : AppCompatActivity(),UserProfileView {

    var username : String = ""
    var presenter: UserProfilePresenter? = UserProfilePresenter(UserProfileModel(),this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        if (intent.extras!!.getString("Username") != null) {
            username = intent.extras!!.getString("Username")!!
            presenter!!.getInfo(username)
        }
    }

    override fun showUserProfileView(info: UserProfileData) {
        runOnUiThread {
            Picasso.with(this).load(info.data.avatar_url).placeholder(R.mipmap.ic_launcher_round)
                .into(headImageView)
        }
    }
}