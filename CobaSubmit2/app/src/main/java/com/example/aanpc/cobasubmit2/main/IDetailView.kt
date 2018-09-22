package com.example.aanpc.cobasubmit2.main

import com.dicoding.kotlinacademy.model.Team
import com.example.aanpc.cobasubmit2.model.ItemModel

interface IDetailView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<ItemModel>)
    fun showLogoL(data: List<Team>)
    fun showLogoR(data: List<Team>)
}