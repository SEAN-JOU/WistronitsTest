package com.example.wistronitstest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wistronitstest.R
import com.example.wistronitstest.bean.UserProfile
import com.example.wistronitstest.bean.UserProfileData
import com.example.wistronitstest.model.UserProfileModel
import com.example.wistronitstest.presenter.UserProfilePresenter
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
        var userProfile : UserProfile = info.data
        runOnUiThread {
            Picasso.with(this).load(userProfile.avatar_url).placeholder(R.mipmap.ic_launcher_round)
                .into(headImageView)
            nameTextView.text = userProfile.name
            loginTextView.text = userProfile.login
            locationTextView.text = userProfile.location
            linkTextView.text = userProfile.blog
        }
    }
}