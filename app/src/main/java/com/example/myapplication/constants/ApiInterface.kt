package com.example.myapplication.constants

import com.example.myapplication.data_model.JsonData
import retrofit2.Response
import retrofit2.http.GET

interface Posts {
    @GET("/posts")
    suspend fun getAllPosts(): Response<List<JsonData>>
}