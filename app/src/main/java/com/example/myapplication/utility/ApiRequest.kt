//package com.example.myapplication.utility
//
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.http.GET
//import java.io.IOException
//
//class ApiRequest {
//
//    fun call(url:String){
//        val client = Retrofit.Builder()
//            .baseUrl(url)
//            .addConverterFactory()
//            .build()
//            .create(PostService::class.java)
//        client.getPosts().enqueue(object: Callback<AllPosts> {
//            override fun onResponse(call: Call<AllPosts>, response: Response<AllPosts>) {
//                println(call.toString())
//                println(response.body())
//
//            }
//
//            override fun onFailure(call: Call<AllPosts>, t: Throwable) {
//
//                println("some issue occurred")
//            }
//
//        })
//    }
//
//
//
//
//    data class AllPosts(val result: List<Post>)
//    data class Post(val postId:Int, val id:Int, val name:String, val email:String,val body: String)
//
//    interface PostService {
//        @GET("/comments")
//        fun getPosts(): Call<AllPosts>
//    }
//}
//
////{
////    "postId": 1,
////    "id": 1,
////    "name": "id labore ex et quam laborum",
////    "email": "Eliseo@gardner.biz",
////    "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
////},