package com.example.aanpc.cobasubmit2.main

import android.util.Log
import com.dicoding.kotlinacademy.model.EventListResponse
import com.dicoding.kotlinacademy.model.TeamResponse
import com.example.aanpc.cobasubmit2.api.ApiRepository
import com.example.aanpc.cobasubmit2.api.TheSportDBApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailPresenter(private val view: IDetailView,
                      private val apiRepository: ApiRepository,
                      private val gson: Gson) {

    fun getSearchFileName(fileName: String?) {
        view.showLoading()
        doAsync {

            lateinit var data: EventListResponse
            try {
                data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getSearchFileName(fileName)), EventListResponse::class.java)
            }catch (e: Exception){
                uiThread {
                    view.hideLoading()
                    Log.i("error", e.message)
                }
            }


            uiThread {
                view.hideLoading()
                view.showEventList(data.event)
            }

        }
    }

    fun searchTeamsByName(team: String?, isL:Boolean) {
        doAsync {

            lateinit var data: TeamResponse
            try {
                data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.searchteamsByName(team)), TeamResponse::class.java)
            }catch (e: Exception){
                uiThread {
                    view.hideLoading()
                    Log.i("error", e.message)
                }
            }


            uiThread {
                if (isL)
                    view.showLogoL(data.teams)
                else
                    view.showLogoR(data.teams)
            }

        }
    }
}