package com.example.happyshopping.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.happyshopping.R
import com.example.happyshopping.data.repository.RepositoryImpl
import com.example.happyshopping.ui.home.HomeViewModel

class MainActivity : AppCompatActivity() {
    val viewModel : HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getAllCategories()
    }
}