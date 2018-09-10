package com.example.aanpc.cobakotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.*
import kotlinx.android.synthetic.main.main_activity.*
import android.os.Build
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var items: MutableList<DataPojo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        MainActivityUI().setContentView(this)
        setContentView(R.layout.main_activity)

        if (Build.VERSION.SDK_INT >= 28) {
            val actionBar = actionBar
            actionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        setDataPojo()
        list_r.layoutManager =  LinearLayoutManager(this)
        list_r.adapter = AdapterItem(this, items){
            val toast = Toast.makeText(applicationContext, it.text1, Toast.LENGTH_SHORT)
            toast.show()
            startActivity(intentFor<SecondActivity>("name" to it.text1, "idx" to it.image).singleTop())
        }
    }

    fun setDataPojo(){
        val name = resources.getStringArray(R.array.image_name)
        val image = resources.obtainTypedArray(R.array.image_res)
        items = mutableListOf()
        for(i in 0..(image.length()-1)){
            Log.i("imagex:",image.getResourceId(i,0).toString())
            items.add(DataPojo(image.getResourceId(i,0),name[i]))
        }
    }


}
