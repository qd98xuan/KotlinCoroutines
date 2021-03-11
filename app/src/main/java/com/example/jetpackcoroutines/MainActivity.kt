package com.example.jetpackcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    var button:Button?=null
    var text:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.get_data)
        text = findViewById(R.id.text)
        val netViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        button?.setOnClickListener{
            netViewModel.getFiction(this)
        }
        netViewModel.weatherinfo.observe(this, Observer {
            text?.setText(it.city)
        })
    }
}