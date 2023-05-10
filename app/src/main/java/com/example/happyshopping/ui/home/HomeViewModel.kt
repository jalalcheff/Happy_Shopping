package com.example.happyshopping.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.happyshopping.data.model.AllCategoriesResponse
import com.example.happyshopping.data.model.AllProductsResponse
import com.example.happyshopping.data.remote.Api
import com.example.happyshopping.data.repository.IRepository
import com.example.happyshopping.data.repository.RepositoryImpl
import com.example.happyshopping.ui.util.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel:ViewModel() {
    private val repository:IRepository=RepositoryImpl(Api.apiService)

    private val _topRated = MutableLiveData<State<AllProductsResponse>>()
    private val _limited = MutableLiveData<State<AllProductsResponse>>()
    private val _cheapest = MutableLiveData<State<AllProductsResponse>>()
    val topRated : MutableLiveData<State<AllProductsResponse>> get() = _topRated
    val limited : MutableLiveData<State<AllProductsResponse>>  get() = _limited
    val cheapest : MutableLiveData<State<AllProductsResponse>>  get() = _cheapest
    init {
        getAllTopRated()
        getAllLimited()
        getAllCheapest()
    }
    fun getAllTopRated(){

        repository.onGetAllProductsSuccess().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
            (::onGetAllTopRatedSuccess),
            (::onGetAllTopRatedError)
        )
    }
    fun getAllLimited(){

        repository.onGetAllProductsSuccess().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
            (::onGetAllLimitedSuccess),
            (::onGetAllLimitedError)
        )
    }
    fun getAllCheapest(){

        repository.onGetAllProductsSuccess().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
            (::onGetAllCheapestSuccess),
            (::onGetAllCheapestError)
        )
    }
    private fun onGetAllTopRatedSuccess(categoriesState:State<AllProductsResponse>){
        _topRated.postValue(State.Loading)
        categoriesState.toData()?.let {response->
            _topRated.postValue(State.Success(response))

        }
    }
    private fun onGetAllTopRatedError(error:Throwable)
    {
        _topRated.postValue(State.Fail(error.message.toString()))
    }
    private fun onGetAllLimitedSuccess(categoriesState:State<AllProductsResponse>){
        _limited.postValue(State.Loading)
        categoriesState.toData()?.let {response->
            _limited.postValue(State.Success(response))
            Log.i("jalal",response[0].description.toString())
        }
    }
    private fun onGetAllLimitedError(error:Throwable)
    {
        _limited.postValue(State.Fail(error.message.toString()))
    }
    private fun onGetAllCheapestSuccess(categoriesState:State<AllProductsResponse>){
        _cheapest.postValue(State.Loading)
        categoriesState.toData()?.let {response->
            _cheapest.postValue(State.Success(response))
        }
    }
    private fun onGetAllCheapestError(error:Throwable)
    {
        _cheapest.postValue(State.Fail(error.message.toString()))
    }

}