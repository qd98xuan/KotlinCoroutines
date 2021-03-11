package com.example.jetpackcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackcoroutines.rv.People
import com.example.jetpackcoroutines.rv.RecycleAdapter

class MainActivity : AppCompatActivity() {
    var button: Button? = null
    var text: TextView? = null
    var recycleview: RecyclerView? = null
    var addLine: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.get_data)
        text = findViewById(R.id.text)
        recycleview = findViewById(R.id.recycleview)
        addLine = findViewById(R.id.add_line)
        val netViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        button?.setOnClickListener {
            netViewModel.getFiction(this)
        }
        netViewModel.weatherinfo.observe(this, Observer {
            text?.setText(it.city)
        })
        val recycleAdapter = RecycleAdapter(applicationContext)
        netViewModel.people.observe(this, {
            recycleAdapter.people = it
            recycleAdapter.notifyDataSetChanged()
        })
        recycleview?.adapter = recycleAdapter
        recycleview?.layoutManager = LinearLayoutManager(this)
        addLine?.setOnClickListener {
            netViewModel.addLine()
        }
    }
}