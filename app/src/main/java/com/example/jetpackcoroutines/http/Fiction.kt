package com.example.jetpackcoroutines.http

import com.google.gson.annotations.SerializedName

//"weatherinfo": {
//		"city": "太仓",
//		"cityid": "101190408",
//		"temp": "22.8",
//		"WD": "东风",
//		"WS": "小于3级",
//		"SD": "81%",
//		"AP": "1005.5hPa",
//		"njd": "暂无实况",
//		"WSE": "<3",
//		"time": "17:55",
//		"sm": "3.2",
//		"isRadar": "0",
//		"Radar": ""
//	}
data class Fiction(
    var weatherinfo: Weatherinfo
)

data class Weatherinfo(
    var city: String,
    var cityid: String,
    var temp: String,
    var WD: String,
    var WS: String,
    var SD: String,
    var AP: String,
    var njd:String,
    var WSE:String,
    var time:String,
    var sm:String,
    var isRadar:String
)
