package com.example.wistronitstest.api

import android.os.Looper
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import com.google.gson.internal.`$Gson$Types`
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

object ApiManager {
  const val SERVER_USERS: String = "https://api.github.com/users"
  const val TAG: String = "WistronitsTest"
}