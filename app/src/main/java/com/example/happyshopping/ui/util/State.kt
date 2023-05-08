package com.example.happyshopping.ui.util

sealed class State<out T> {
    data class Success<T>(val data:T):State<T>()
    data class Fail(val error:String):State<Nothing>()
    object Loading:State<Nothing>()
    fun toData():T? = if(this is Success) data else null
    }