package com.example.aanpc.cobakotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class RAdapter(private val context: Context, private val list: List<RModel>, private val listener:(RModel)->Unit)
    : RecyclerView.Adapter<RAdapter.ViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int)
            =ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, p0, false))

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItem(list[p1], listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val name = view.findViewById<TextView>(R.id.name)
        private val image = view.findViewById<ImageView>(R.id.image)

        fun bindItem(items: RModel, listener: (RModel) -> Unit) {
            name.text = items.name
            Glide.with(itemView.context).load(items.image).into(image)
            itemView.setOnClickListener { listener(items) }
        }
    }
}