package com.example.myapplication.constants

import com.example.myapplication.data_model.JsonData
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


object RetrofitHelper {
    val baseUrl = "https://jsonplaceholder.typicode.com/"
    fun getInstance():Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }
}



//class ApiConstants {
//    companion object {
//        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
//    }
//}




