package com.example.happyshopping.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.happyshopping.R
import com.example.happyshopping.data.repository.RepositoryImpl

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repo = RepositoryImpl()
        repo.getAllCategories()
    }
}