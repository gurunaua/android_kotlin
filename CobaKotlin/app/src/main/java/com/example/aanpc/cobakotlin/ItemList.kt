package com.example.aanpc.cobakotlin

import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView


class ItemList : AnkoComponent<AdapterItem> {

    override fun createView(ui: AnkoContext<AdapterItem>) = with(ui) {
        verticalLayout {
            padding= dip(16)
            cardView {
                linearLayout {
                    orientation=LinearLayout.HORIZONTAL
                    lparams(width= matchParent)
                    imageView(R.drawable.img_barca){
                        id=R.id.imageItemx
                    }.lparams(height = dip(50), width = dip(50))
                    textView("One") {
                        id=R.id.text1ya
                    }.lparams{margin=dip(10)}
                }
            }
        }
    }
}