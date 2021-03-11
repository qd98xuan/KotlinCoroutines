package com.example.jetpackcoroutines.rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackcoroutines.R

class RecycleAdapter(val context:Context):RecyclerView.Adapter<RecycleAdapter.ViewHolder>(){
    var people= listOf<People>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycle_item,parent,false)
        val viewHolder=ViewHolder(view)
        //设置监听事件
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecycleAdapter.ViewHolder, position: Int) {
        holder.age!!.setText(people.get(position).age.toString())
        holder.name!!.setText(people.get(position).name)
        holder.hobbit!!.setText(people.get(position).hobbit)
    }

    override fun getItemCount(): Int {
        return people.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name:TextView?=null
        var age:TextView?=null
        var hobbit:TextView?=null
        init {
            name = itemView.findViewById(R.id.name)
            age = itemView.findViewById(R.id.age)
            hobbit = itemView.findViewById(R.id.hobbit)
        }
    }
}