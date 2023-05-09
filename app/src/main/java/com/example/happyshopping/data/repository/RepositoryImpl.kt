package com.example.happyshopping.data.repository

import com.example.happyshopping.data.model.AllCategoriesResponse
import com.example.happyshopping.data.remote.Api
import com.example.happyshopping.data.remote.MarvelService
import com.example.happyshopping.ui.util.State
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class RepositoryImpl(val categories:MarvelService):IRepository {
   // val categories:MarvelService= Api.apiService
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

    override fun onGetAllCategoriesSuccess(): Observable<State<AllCategoriesResponse>> {
        return wrapWithState{categories.getAllCategories()}
    }

    private fun wrapWithState(allCategories:()-> Single<Response<AllCategoriesResponse>>): Observable<State<AllCategoriesResponse>> {
 return allCategories().map<State<AllCategoriesResponse>> { response->
    if (response.isSuccessful)
    {
        State.Success(response.body()!!)
    }
    else
        State.Fail(response.message())
}.onErrorReturn { State.Fail(it.message?:"unKnown Error") }
    .startWith (Observable.just(State.Loading))
    }
}