package com.example.jetpackcoroutines.http

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("data/sk/101190408.html")
    fun getFinction(): Call<Fiction>
}