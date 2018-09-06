package com.example.aanpc.cobakotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var items: MutableList<RModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListModel();

        val recycle = findViewById<RecyclerView>(R.id.list_r)
        recycle.layoutManager =  LinearLayoutManager(this)
        recycle.adapter = RAdapter(this,items){
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    fun setListModel(){
        items = mutableListOf();
        val name = resources.getStringArray(R.array.image_name)
        val image = resources.obtainTypedArray(R.array.image_res)
        for (i in name.indices){
            items.add(RModel(name[i], image.getResourceId(i,0)) )
        }
        for (i in name.indices){
            items.add(RModel(name[i], image.getResourceId(i,0)) )
        }

        for (i in name.indices){
            items.add(RModel(name[i], image.getResourceId(i,0)) )
        }


        image.recycle()
    }


}
