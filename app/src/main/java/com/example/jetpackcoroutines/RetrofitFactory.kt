package com.example.jetpackcoroutines

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    companion object {
        fun instance():Retrofit{
            var build: Retrofit? = null
            if (build == null) {
                build = Retrofit
                    .Builder()
                    .baseUrl("http://www.weather.com.cn/")
                    .addConverterFactory(GsonConverterFactory.create(Gson()))
                    .build()
            }
            return build!!
        }
    }
}