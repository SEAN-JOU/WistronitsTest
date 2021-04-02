package com.example.wistronitstest.presenter

import com.example.wistronitstest.model.UserInfo
import com.example.wistronitstest.model.UserInfoData
import com.example.wistronitstest.model.UsersListModel
import com.example.wistronitstest.view.UsersListView


class UsersListPresenter constructor(var model: UsersListModel?, var view: UsersListView?) {

    fun getInfo() {
        model?.getUserList(object : UsersListModel.CallBack {
            override fun data(info: UserInfoData) {
                view?.showUsersListView(info)
            }
        })
    }
    fun destroy() {
        model = null
        view = null
    }
}