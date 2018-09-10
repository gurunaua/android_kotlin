package com.example.aanpc.cobakotlin

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*


class SecondActivityUI() : AnkoComponent<SecondActivity> {

    lateinit var textview: TextView
    lateinit var imageview: ImageView

    override fun createView(ui: AnkoContext<SecondActivity>) = with(ui) {

        verticalLayout {
            linearLayout{
                orientation = LinearLayout.HORIZONTAL
                gravity= Gravity.CENTER_HORIZONTAL
                imageview = imageView(R.drawable.img_barca) {
                    padding = dip(10)
                }.lparams(height = dip(200))
            }

            textview = textView(){gravity= Gravity.CENTER}.lparams(width = matchParent)
        }

    }

    fun set(text: String, idx: Int, secondActivity :SecondActivity) {
        textview.text = text
        Glide.with(secondActivity).load(idx).into(imageview)
    }



}