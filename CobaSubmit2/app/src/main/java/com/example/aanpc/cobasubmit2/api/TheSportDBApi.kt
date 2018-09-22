package com.example.aanpc.cobasubmit2.api

import android.net.Uri
import com.example.aanpc.cobasubmit2.BuildConfig

object TheSportDBApi {

    fun getLastEvent(id: String?): String {// https://www.thesportsdb.com/api/v1/json/1/eventslast.php?id=133602
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("eventspastleague.php")
                .appendQueryParameter("id", id)
                .build()
                .toString()
    }

    fun getNextEvent(id: String?): String {// https://www.thesportsdb.com/api/v1/json/1/eventsnext.php?id=133602
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("eventsnextleague.php")
                .appendQueryParameter("id", id)
                .build()
                .toString()
    }


    fun searchteamsByName(nameTeam: String?): String {// https://www.thesportsdb.com/api/v1/json/1/searchteams.php?t=Arsenal
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("searchteams.php")
                .appendQueryParameter("t", nameTeam)
                .build()
                .toString()
    }

    fun getSearchFileName(fileName: String?): String {// https://www.thesportsdb.com/api/v1/json/1/searchfilename.php?e=English_Premier_League_2015-04-26_Arsenal_vs_Chelsea

        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("searchfilename.php")
                .appendQueryParameter("e", fileName)
                .build()
                .toString()
    }
}