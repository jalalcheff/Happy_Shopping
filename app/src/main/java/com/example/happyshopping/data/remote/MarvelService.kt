package com.example.happyshopping.data.remote

import com.example.happyshopping.data.model.AllCategoriesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MarvelService {
    @GET("/products/categories")
fun getAllCategories():Single<AllCategoriesResponse>
}