package com.example.wistronitstest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.wistronitstest.R
import kotlinx.android.synthetic.main.activity_main.*

class UsersListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usersListRecyclerView
    }
}