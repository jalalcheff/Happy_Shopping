package com.example.happyshopping.ui.util

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T>showLoading(view: View,state:State<T>?)
{
    if (state is State.Loading)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.INVISIBLE
}
@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T>showWhenSuccess(view: View , state: State<T>?)
{
    if (state is State.Success)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.INVISIBLE
}