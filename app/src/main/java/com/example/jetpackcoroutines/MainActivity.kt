package com.example.jetpackcoroutines

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.jetpackcoroutines.http.BaseResp
import com.example.jetpackcoroutines.http.NBJKEntry
import com.example.jetpackcoroutines.http.Retrofit
import com.permissionx.guolindev.PermissionX
import com.permissionx.guolindev.callback.RequestCallback
import kotlinx.coroutines.*
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    var image1: ImageView? = null
    var image2: ImageView? = null
    var imageSlice1: ImageView? = null
    var imageSlice2: ImageView? = null
    var progress: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        imageSlice1 = findViewById(R.id.slicePic1)
        imageSlice2 = findViewById(R.id.slicePic2)
        progress = findViewById(R.id.progress_circular)
        PermissionX.init(this).permissions(android.Manifest.permission.INTERNET)
            .request(object : RequestCallback {
                override fun onResult(
                    allGranted: Boolean,
                    grantedList: MutableList<String>?,
                    deniedList: MutableList<String>?
                ) {
                    if (allGranted) {
//                        CoroutineScope(Dispatchers.Main).launch {
//                            val imagePic1 =
//                                async { getImage("https://d47jbcq60tnr6.cloudfront.net/20201221/32567-1fwd97f.fnee.png") }
//                            val imagePic2 =
//                                async { getImage("https://d47jbcq60tnr6.cloudfront.net/2020118/1177-1jqxfaq.pgo1.PNG") }
//                            setImage(imagePic1.await(), imagePic2.await())
//                            progress?.visibility = View.INVISIBLE
//                        }
                        getNBJK()
                    }
                }
            })
    }


    fun setImage(imagePic1: Bitmap, imagePic2: Bitmap) {
        image1?.setImageBitmap(imagePic1)
        image2?.setImageBitmap(imagePic2)
        val bitmapSlice1 =
            Bitmap.createBitmap(
                imagePic1,
                0,
                0,
                imagePic1.width / 2,
                imagePic1.height / 2
            )
        val bitmapSlice2 = Bitmap.createBitmap(
            imagePic1,
            imagePic1.width / 3 * 2,
            imagePic1.height / 3 * 2,
            imagePic1.width / 3,
            imagePic1.height / 3
        )
        imageSlice1?.setImageBitmap(bitmapSlice1)
        imageSlice2?.setImageBitmap(bitmapSlice2)
    }

    suspend fun getImage(url: String) = withContext(Dispatchers.IO) {
        progress?.visibility = View.VISIBLE
        val url =
            URL(url)
        val httpURLConnection = url.openConnection() as HttpsURLConnection
        val inputStream = httpURLConnection.inputStream
        BitmapFactory.decodeStream(inputStream)

    }

    inline fun Int.pow(a: Int): Double {
        return Math.pow(this.toDouble(), a.toDouble())
    }
    fun <T> BaseResp<T>.dataConvert(): T{
        if (code==200){
            return data
        }else{
            throw Exception(msg)
        }
    }
    private fun getNBJK() {
        GlobalScope.launch(Dispatchers.Default) {
            try {
                var postNBJK = Retrofit
                    .getInstance()
                    .postNBJK(
                        "HX",
                        "370202199811250423",
                        "13791914582",
                        "%E9%84%9E%E5%B7%9E%E5%8C%BA+%E7%A6%8F%E6%98%8E%E8%A1%97%E9%81%93",
                        "FUNMING",
                        1, 22
                    ).execute()
                if (postNBJK.isSuccessful){
                    Log.i("postNBJK",postNBJK.message())
                }else{
                    Log.i("postNBJK",postNBJK.errorBody().toString())
                }
            }catch (e:Exception){
                print(e)
            }


        }
    }
}