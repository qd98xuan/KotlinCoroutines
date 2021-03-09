package com.example.jetpackcoroutines.http


import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("artifact/com.squareup.retrofit2/converter-gson/2.9.0")
    fun getName(): Response<String>

    @FormUrlEncoded
    @Headers(
        "User-Agent:mozilla/5.0 (linux; u; android 4.1.2; zh-cn; mi-one plus build/jzo54k) applewebkit/534.30 (khtml, like gecko) version/4.0 mobile safari/534.30 micromessenger/5.0.1.352",
        "Host:nbyzkj.zhangzhengyun.com",
        "Cookie:PHPSESSID=olfladkfhj11qi036qe68cjd47"
    )
    @POST("index/vaccine/vaccineadd.html")
    suspend fun postNBJK(
        @Field("name") name: String,
        @Field("codeNo") codeNo: String,
        @Field("mobile") mobile: String,
        @Field("streetid") streetid: String,
        @Field("address") address: String,
        @Field("vaccineid") vaccineid: Int,
        @Field("orgid") orgid: Int
    ): Call<NBJKEntry>
}