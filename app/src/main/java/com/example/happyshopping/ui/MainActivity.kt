package com.example.happyshopping.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.happyshopping.R
import com.example.happyshopping.data.repository.RepositoryImpl
import com.example.happyshopping.databinding.ActivityMainBinding
import com.example.happyshopping.ui.category.CategoryViewModel
import com.example.happyshopping.ui.home.HomeViewModel

class MainActivity : AppCompatActivity() {
lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


    }
}