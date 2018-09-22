package com.example.aanpc.cobasubmit2.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aanpc.cobasubmit2.R
import com.example.aanpc.cobasubmit2.model.ItemModel
import com.example.aanpc.cobasubmit2.util.formatDate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.*

class EventAdapter(private val context: Context, private val list: List<ItemModel>, private val listener:(ItemModel)->Unit)
    : RecyclerView.Adapter<EventAdapter.ViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int)
            =ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, p0, false))

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItem(list[p1], listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(items: ItemModel, listener: (ItemModel) -> Unit) {
            tv_item_date.text = formatDate(items.dateEvent!!)
            tv_item_score_left.text = items.intHomeScore
            tv_item_score_right.text = items.intAwayScore
            tv_item_team_name_left.text = items.strHomeTeam
            tv_item_team_name_right.text = items.strAwayTeam
            itemView.setOnClickListener { listener(items) }
        }
    }
}