package com.example.happyshopping.data.repository

import android.util.Log
import com.example.happyshopping.data.remote.Api

class RepositoryImpl {
    val categories= Api.apiService
    fun getAllCategories()
    {
//        categories.getAllCategories().subscribe(
//            {
//                Log.i("jalalCheff",it[0].toString())
//            },
//            {
//                Log.i("jalalCheff",it.message.toString())
//            }
//        )
    }
}