package com.example.happyshopping.data.remote

import com.example.happyshopping.data.model.AllCategoriesResponse
import com.example.happyshopping.data.model.AllProductsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface MarvelService {
    @GET("/products/categories")
fun getAllCategories():Single<Response<AllCategoriesResponse>>

@GET("/products")
fun getAllProducts():Single<Response<AllProductsResponse>>
}