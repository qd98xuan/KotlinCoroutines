package com.example.jetpackcoroutines

import android.Manifest
import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackcoroutines.http.Fiction
import com.example.jetpackcoroutines.http.RetrofitService
import com.example.jetpackcoroutines.http.Weatherinfo
import com.example.jetpackcoroutines.http.dataConvert
import com.example.jetpackcoroutines.rv.People
import com.permissionx.guolindev.PermissionX
import com.permissionx.guolindev.callback.RequestCallback
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await

class MainViewModel : ViewModel() {
    var weatherinfo = MutableLiveData<Weatherinfo>()
    fun getFiction(activity: FragmentActivity) {
        PermissionX.init(activity).permissions(Manifest.permission.INTERNET)
            .request(object : RequestCallback {
                override fun onResult(
                    allGranted: Boolean,
                    grantedList: MutableList<String>?,
                    deniedList: MutableList<String>?
                ) {
                    if (allGranted) {
                        GlobalScope.launch {
                            withContext(Dispatchers.Main) {
                                var datas = getDatas()
                                weatherinfo.value = datas
                            }
                        }
                    }
                }

                private suspend fun getDatas(): Weatherinfo {
                    val data = withContext(Dispatchers.IO) {
                        var retrofitService = RetrofitFactory.instance()
                            .create(RetrofitService::class.java)
                        retrofitService.getFinction().await()
                    }
                    return data.weatherinfo
                }

            })
    }

    var p = arrayListOf<People>(
        People("张三", "足球", 18),
        People("李四", "篮球", 19),
        People("王二", "羽毛球", 30)
    )
    var people = MutableLiveData<ArrayList<People>>(
        p
    )

    fun addLine() {
        p.add(People("王二", "羽毛球", 30))
        people.value = p
    }
}