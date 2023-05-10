package com.example.happyshopping.ui.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.happyshopping.data.model.AllCategoriesResponse
import com.example.happyshopping.data.remote.Api
import com.example.happyshopping.data.repository.IRepository
import com.example.happyshopping.data.repository.RepositoryImpl
import com.example.happyshopping.ui.util.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers

class CategoryViewModel:ViewModel() {
    private val repository:IRepository=RepositoryImpl(Api.apiService)

    private val _category = MutableLiveData<State<AllCategoriesResponse>>()
    val category : LiveData<State<AllCategoriesResponse>> get() = _category
    val jalal = "jalal"
    init {
        getAllCategories()
    }
    fun getAllCategories(){
        _category.postValue(State.Loading)
        repository.onGetAllCategoriesSuccess().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy (
                onNext =     (::onGetAllCategoriesSuccess) ,
            onError = (::onGetAllCategoriesError)
                )
    }
    private fun onGetAllCategoriesSuccess(categoriesState:State<AllCategoriesResponse>){

            categoriesState.toData()?.let {response->
                _category.postValue(State.Success(response))
                Log.i("jalalCheff",response[0])
            }

    }
    private fun onGetAllCategoriesError(error:Throwable)
    {
        Log.i("jalalCheff",error.message?.get(0).toString())
        _category.postValue(State.Fail(error.message.toString()))
    }

}