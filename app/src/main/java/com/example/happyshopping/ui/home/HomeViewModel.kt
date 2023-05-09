package com.example.happyshopping.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.happyshopping.data.model.AllCategoriesResponse
import com.example.happyshopping.data.remote.Api
import com.example.happyshopping.data.repository.IRepository
import com.example.happyshopping.data.repository.RepositoryImpl
import com.example.happyshopping.ui.util.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel:ViewModel() {
    private val repository:IRepository=RepositoryImpl(Api.apiService)
    val category=MutableLiveData<State<AllCategoriesResponse>>()
    init {
        getAllCategories()
    }
    fun getAllCategories(){

        repository.onGetAllCategoriesSuccess().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
            (::onGetAllCategoriesSuccess),
            (::onGetAllCategoriesError)
        )
    }
    private fun onGetAllCategoriesSuccess(categoriesState:State<AllCategoriesResponse>){
        category.postValue(State.Loading)
        categoriesState.toData()?.let {response->
            category.postValue(State.Success(response))
        }
    }
    private fun onGetAllCategoriesError(error:Throwable)
    {
        category.postValue(State.Fail(error.message.toString()))
    }

}