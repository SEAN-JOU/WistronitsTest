package com.example.wistronitstest.presenter

import com.example.wistronitstest.bean.UsersListData
import com.example.wistronitstest.model.UsersListModel
import com.example.wistronitstest.view.UsersListView


class UsersListPresenter constructor(var model: UsersListModel?, var view: UsersListView?) {

    fun getInfo() {
        model?.getUserList(object : UsersListModel.CallBack {
            override fun data(usersListData: UsersListData) {
                view?.showUsersListView(usersListData)
            }
        })
    }
    fun destroy() {
        model = null
        view = null
    }
}