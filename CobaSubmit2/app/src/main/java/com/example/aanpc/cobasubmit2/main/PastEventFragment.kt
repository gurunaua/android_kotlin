package com.example.aanpc.cobasubmit2.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.example.aanpc.cobasubmit2.R
import com.example.aanpc.cobasubmit2.adapter.EventAdapter
import com.example.aanpc.cobasubmit2.api.ApiRepository
import com.example.aanpc.cobasubmit2.model.ItemModel
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout


/**
 * A simple [Fragment] subclass.
 *
 */
class PastEventFragment : Fragment(), IView {

    private lateinit var rv: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout

    lateinit var eventPresenter : EventPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val request = ApiRepository()
        val gson = Gson()
        hideLoading()
        eventPresenter = EventPresenter(this, request, gson)
        swipeRefresh.onRefresh {
            eventPresenter.getEventLastList("4328")
        }
        eventPresenter.getEventLastList("4328")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_item_one, container, false)
        return UI {
            linearLayout {
                lparams (width = matchParent, height = wrapContent)
                orientation = LinearLayout.VERTICAL

                swipeRefresh = swipeRefreshLayout {
                    setColorSchemeResources(R.color.colorAccent,
                            android.R.color.holo_green_light,
                            android.R.color.holo_orange_light,
                            android.R.color.holo_red_light)

                    relativeLayout{
                        lparams (width = matchParent, height = wrapContent)

                        rv = recyclerView {
                            lparams (width = matchParent, height = wrapContent)
                            layoutManager = LinearLayoutManager(ctx)
                        }

                    }
                }
            }
        }.view


    }


    companion object {
        fun newInstance(): PastEventFragment = PastEventFragment()
    }

    override fun showLoading() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
    }

    override fun showEventList(data: List<ItemModel>) {
        swipeRefresh.isRefreshing = false
        data.forEach {
            Log.d("dddd",it.strHomeTeam)
        }
        rv.layoutManager =  LinearLayoutManager(this.context)
        rv.adapter = EventAdapter(activity!!.baseContext, data){
            val toast = Toast.makeText(activity!!.baseContext, it.dateEvent, Toast.LENGTH_SHORT)
            toast.show()
            startActivity(intentFor<DetailActivity>(
                    "fileName" to it.strFilename,
                    "teamL" to it.strHomeTeam,
                    "teamR" to it.strAwayTeam
            ).singleTop())
        }

    }
}
