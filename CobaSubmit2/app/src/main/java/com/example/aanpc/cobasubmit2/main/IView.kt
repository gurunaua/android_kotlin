package com.example.aanpc.cobasubmit2.main

import com.example.aanpc.cobasubmit2.model.ItemModel

interface IView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<ItemModel>)
}