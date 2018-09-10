package com.example.aanpc.cobakotlin

import android.content.Context
import android.content.res.Resources
import android.content.res.TypedArray
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class AdapterItem(private val context: Context, val datasPojo: List<DataPojo>, private val listener: (DataPojo) -> Unit) : RecyclerView.Adapter<AdapterItem.Holder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        return Holder(ItemList().createView(AnkoContext.Companion.create(context, this, false)))
    }

    override fun getItemCount(): Int = datasPojo.size

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.bindView(datasPojo.get(p1), listener)
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text1y by lazy { itemView.find<TextView>(R.id.text1ya) }
        val imageItem by lazy { itemView.find<ImageView>(R.id.imageItemx) }
        fun bindView(item: DataPojo, listener: (DataPojo) -> Unit) {
            Log.i("imagevv: ", item.image.toString())
            text1y.text = item.text1
            Glide.with(itemView.context).load(item.image).into(imageItem)
            itemView.setOnClickListener { listener(item) }
        }
    }


}
