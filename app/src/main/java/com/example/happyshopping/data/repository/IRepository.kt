package com.example.happyshopping.data.repository

import com.example.happyshopping.data.model.AllCategoriesResponse
import com.example.happyshopping.ui.util.State
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

interface IRepository {
    fun onGetAllCategoriesSuccess():Observable<State<AllCategoriesResponse>>
}