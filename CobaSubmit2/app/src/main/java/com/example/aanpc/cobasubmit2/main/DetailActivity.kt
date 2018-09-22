package com.example.aanpc.cobasubmit2.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.kotlinacademy.model.Team
import com.example.aanpc.cobasubmit2.R
import com.example.aanpc.cobasubmit2.api.ApiRepository
import com.example.aanpc.cobasubmit2.model.ItemModel
import com.example.aanpc.cobasubmit2.util.formatDate
import com.example.aanpc.cobasubmit2.util.gone
import com.example.aanpc.cobasubmit2.util.invisible
import com.example.aanpc.cobasubmit2.util.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail1.*

class DetailActivity : AppCompatActivity(), IDetailView {

    lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail1)

        title = "Match Detail"
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        val request = ApiRepository()
        val gson = Gson()
        hideLoading()
        val intent = intent
        val name = intent.getStringExtra("fileName")
        val teamL = intent.getStringExtra("teamL")
        val teamR = intent.getStringExtra("teamR")
        presenter = DetailPresenter(this, request, gson)
        presenter.getSearchFileName(name.replace(" ", "_"))
        presenter.searchTeamsByName(teamL, true)
        presenter.searchTeamsByName(teamR, false)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun showLoading() {
        progressBarDetail1.visible()
    }

    override fun hideLoading() {
        progressBarDetail1.invisible()
    }

    override fun showEventList(data: List<ItemModel>) {
        progressBarDetail1.invisible()
        tv_detail1_date.text = formatDate(data.get(0).dateEvent?:"")

        if (data.get(0).intHomeScore != null && data.get(0).intHomeScore!!.length > 0) {
            tv_detail1_score_left.text = data.get(0).intHomeScore ?: ""
            tv_detail1_score_right.text = data.get(0).intAwayScore ?: ""
            tv_detail1_score_left.visible()
            tv_detail1_score_right.visible()

            tv_detail1_formation_left.text = data.get(0).strHomeFormation ?: ""
            tv_detail1_formation_right.text = data.get(0).strAwayFormation ?: ""

            iv_detail1_left.invisible()
            iv_detail1_right.invisible()
        } else {
            tv_detail1_score_left.invisible()
            tv_detail1_score_right.invisible()
            iv_detail1_left.visible()
            iv_detail1_right.visible()

            tv_detail1_formation_left.gone()
            tv_detail1_formation_right.gone()

        }

        tv_detail1_team_name_left.text = data.get(0).strHomeTeam
        tv_detail1_team_name_right.text = data.get(0).strAwayTeam
        tv_detail1_goals_l.text = data.get(0).strHomeGoalDetails ?: ""
        tv_detail1_goals_r.text = data.get(0).strAwayGoalDetails ?: ""
        tv_detail1_shots_l.text = data.get(0).intHomeShots ?: ""
        tv_detail1_shots_r.text = data.get(0).intAwayShots ?: ""
        tv_detail1_goolkeeper_l.text = data.get(0).strHomeLineupGoalkeeper ?: ""
        tv_detail1_goolkeeper_r.text = data.get(0).strAwayLineupGoalkeeper ?: ""
        tv_detail1_defence_l.text = data.get(0).strHomeLineupDefense ?: ""
        tv_detail1_defence_r.text = data.get(0).strAwayLineupDefense ?: ""
        tv_detail1_midfiled_l.text = data.get(0).strHomeLineupMidfield ?: ""
        tv_detail1_midfiled_r.text = data.get(0).strAwayLineupMidfield ?: ""
        tv_detail1_forward_l.text = data.get(0).strHomeLineupForward ?: ""
        tv_detail1_forward_r.text = data.get(0).strAwayLineupForward ?: ""
        tv_detail1_substitutes_l.text = data.get(0).strHomeLineupSubstitutes ?: ""
        tv_detail1_substitutes_r.text = data.get(0).strAwayLineupSubstitutes ?: ""
        tv_detail1_formation_left.text = data.get(0).strHomeFormation ?: ""
        tv_detail1_formation_right.text = data.get(0).strAwayFormation ?: ""

    }


    override fun showLogoL(data: List<Team>) {
        Glide.with(this).load(data.get(0).teamBadge).into(iv_detail1_left)
    }

    override fun showLogoR(data: List<Team>) {
        Glide.with(this).load(data.get(0).teamBadge).into(iv_detail1_right)
    }
}
