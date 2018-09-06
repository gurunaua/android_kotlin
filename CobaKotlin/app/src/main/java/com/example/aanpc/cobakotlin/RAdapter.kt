package com.example.aanpc.cobakotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item.*

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

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(items: RModel, listener: (RModel) -> Unit) {
            name.text = items.name
            Glide.with(itemView.context).load(items.image).into(image)
            itemView.setOnClickListener { listener(items) }
        }
    }
}