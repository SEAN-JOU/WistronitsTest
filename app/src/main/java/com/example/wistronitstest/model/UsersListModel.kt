package com.example.wistronitstest.model

import android.util.Log
import com.example.wistronitstest.bean.UserInfo
import com.example.wistronitstest.bean.UsersListData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.IOException

class UsersListModel {
    interface CallBack {
        fun data(info: UsersListData)
    }

    fun getUserList(callBack: CallBack) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.github.com/users")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("aaaaaaa", e.message.toString())
            }
            override fun onResponse(call: Call, response: Response) {
                val resStr = response.body()!!.string()
                val jsonData = Gson().fromJson<List<UserInfo>>(resStr, object : TypeToken<List<UserInfo>>() {}.type)
                Log.d("aaaaaaa",resStr)
                Log.d("aaaaaaa", jsonData[0].login!!)
                callBack.data(
                    UsersListData(
                        jsonData
                    )
                )
            }
        })
    }
}