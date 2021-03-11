package com.example.jetpackcoroutines.http

import android.util.Log
import java.lang.Exception

data class BaseResp<T>(
    var code: Int = 0,
    var msg: String = "",
    var data: T
)
fun <T> BaseResp<T>.dataConvert():T{
    if (code==200){
        return data
    }else{
        throw Exception(msg)
        Log.i("netmsg",msg)
    }
}
