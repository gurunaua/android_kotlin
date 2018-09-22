package com.example.aanpc.cobasubmit2.main

import android.util.Log
import com.dicoding.kotlinacademy.model.EventListResultResponse
import com.example.aanpc.cobasubmit2.api.ApiRepository
import com.example.aanpc.cobasubmit2.api.TheSportDBApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EventPresenter(private val view: IView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson) {


    fun getEventLastList(id: String?) {
        view.showLoading()
        doAsync {

            lateinit var data: EventListResultResponse
            try {
                data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getLastEvent(id)), EventListResultResponse::class.java)
            }catch (e: Exception){
                uiThread {
                    view.hideLoading()
                    Log.i("error", e.message)
                }
            }

            uiThread {
                view.hideLoading()
                view.showEventList(data.events)
            }

        }
    }

    fun getEventNextList(id: String?) {
        view.showLoading()
        doAsync {

            lateinit var data: EventListResultResponse
            try {
                data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getNextEvent(id)), EventListResultResponse::class.java)
            }catch (e: Exception){
                uiThread {
                    view.hideLoading()
                    Log.i("error", e.message)
                }
            }

            uiThread {
                view.hideLoading()
                view.showEventList(data.events)
            }

        }
    }

}