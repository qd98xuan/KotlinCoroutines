package com.example.jetpackcoroutines.http
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    companion object {
        var apiService:ApiService?=null
        fun getInstance():ApiService {
            if (apiService==null) {
                val retrofit = Retrofit.Builder().baseUrl("http://nbyzkj.zhangzhengyun.com/")
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .build()
                apiService = retrofit.create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}