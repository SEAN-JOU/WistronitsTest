package com.example.wistronitstest.presenter

import com.example.wistronitstest.bean.UserProfileData
import com.example.wistronitstest.bean.UsersListData
import com.example.wistronitstest.model.UserProfileModel
import com.example.wistronitstest.model.UsersListModel
import com.example.wistronitstest.view.UserProfileView
import com.example.wistronitstest.view.UsersListView


class UserProfilePresenter constructor(var model: UserProfileModel?, var view: UserProfileView?) {

    fun getInfo(username : String) {
        model?.getUserProfile(object : UserProfileModel.CallBack {
            override fun data(userProfileData: UserProfileData) {
                view?.showUserProfileView(userProfileData)
            }
        },username)
    }
    fun destroy() {
        model = null
        view = null
    }
}