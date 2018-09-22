package com.example.aanpc.cobasubmit2.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import com.example.aanpc.cobasubmit2.R

class MainActivity : AppCompatActivity(){

    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title="Football Match Schedule"
        toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        //
        val fa = PastEventFragment.newInstance()
        openFragment(fa)


    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_item1 -> {
                val fa = PastEventFragment.newInstance()
                openFragment(fa)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_item2 -> {
                val fb = NextEventFragment.newInstance()
                openFragment(fb)
                return@OnNavigationItemSelectedListener true
            }
        }
        true
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }



}
