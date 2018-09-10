package com.example.aanpc.cobakotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity = SecondActivityUI()
        activity.setContentView(this)
        val intent = intent
        val name = intent.getStringExtra("name")
        val idx = intent.getIntExtra("idx",0)
        activity.set(name, idx, this)

    }
}
